#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Comparator for a single test pair:
1) Input comparison: LLM extraction → multiset comparison (order-insensitive).
   Fallback: LLM direct judgment (Equal/Not_Equal).
2) Test execution: Python / JavaScript (Jest) / Java (JUnit standalone JAR).
   - Java: (a) compile all .java under classes_dir, then (b) run with --scan-class-path.
3) Output comparison: Compare pass/fail (returncode) of Python vs other test.
"""

import os
import re
import argparse
import subprocess
from pathlib import Path
from typing import List, Tuple, Optional
from collections import Counter

# ====== LLM / LangChain ======
from pydantic import BaseModel, Field
from typing import Literal
from langchain_ollama import ChatOllama
from langchain.prompts import ChatPromptTemplate
from langchain.output_parsers import PydanticOutputParser
from langchain_core.exceptions import OutputParserException

# =========================
# Defaults
# =========================
MODEL_NAME = "qwen2.5-coder:32b-instruct-fp16"
PY_TIMEOUT = 15
JS_TIMEOUT = 20
JAVA_TIMEOUT = 45
JAVAC_TIMEOUT = 60

DEBUG = False
TRUNC = 800  

def dbg(*args):
    if DEBUG:
        print("[DEBUG]", *args)

# =========================
# LLM Schemas & Prompts
# =========================
class ExtractSchema(BaseModel):
    cases: List[List[str]] = Field(default_factory=list)
    ignored_notes: List[str] = Field(default_factory=list)

class AnswerSchema(BaseModel):
    answer: Literal["Equal", "Not_Equal"]

SYSTEM_PROMPT_EXTRACT = """
You are a Software Engineering expert.
Your ONLY job: Extract test INPUT arguments from the given test code and return strict JSON.

Rules:
- Return ONLY JSON. No markdown, no explanations.
- Extract every concrete test invocation (parameterized/data-driven included).
- Focus on INPUT arguments (ignore expected labels/messages).
- Normalize:
  - Lowercase words (except numbers/symbols).
  - Trim spaces; normalize comma spacing to ", ".
  - none/null/undefined -> "null".
  - true/false in lowercase strings.
  - Arrays/tuples as JSON-like strings, e.g., "[1, 2, 3]".
  - If you see Python repetition like "AEIOU" * 5, expand literally.
"""

JUDGE_SYSTEM_PROMPT = r"""
You are a Software Engineering expert.
Your ONLY task is to decide whether TWO test suites use the SAME INPUTS.
Return **ONLY** one of:
{"answer":"Equal"}
or
{"answer":"Not_Equal"}

Rules:
- Compare INPUTS ONLY (arguments passed to the function under test for each concrete test invocation).
- Ignore expected values, assertion messages, helper names, and comments.
- Consider parameterized/data-driven styles (unittest lists, Jest arrays/objects, JUnit arrays/data providers).
- Normalize before comparing:
  - Case-insensitive tokens (except numbers/symbols).
  - Trim spaces; normalize comma spacing to ", ".
  - None/null/undefined -> "null".
  - Booleans to "true"/"false" (lowercase strings).
  - Arrays/tuples -> JSON-like strings, e.g., "[1, 2, 3]".
- Treat the sets of inputs as a **multiset**: order does not matter, counts do.

- Runtime differences matter:
  - Python supports string repetition: "AEIOU" * 5 -> "AEIOUAEIOUAEIOUAEIOUAEIOU".
  - JS/Java do not; only consider them equivalent if the expanded literal appears.

- If and only if ALL concrete input sets match as a multiset, answer {"answer":"Equal"}.
  Otherwise answer {"answer":"Not_Equal"}.
- Do NOT output anything else.
"""

def build_extract_chain(model_name: str = MODEL_NAME):
    parser = PydanticOutputParser(pydantic_object=ExtractSchema)
    prompt = ChatPromptTemplate.from_messages(
        [("system", SYSTEM_PROMPT_EXTRACT), ("human", "{{code}}")],
        template_format="jinja2",
    )
    llm = ChatOllama(model=model_name, temperature=0.0)
    return prompt | llm, parser

def build_judge_chain(model_name: str = MODEL_NAME):
    parser = PydanticOutputParser(pydantic_object=AnswerSchema)
    prompt = ChatPromptTemplate.from_messages(
        [("system", JUDGE_SYSTEM_PROMPT), ("human", "{{question}}")],
        template_format="jinja2",
    )
    llm = ChatOllama(model=model_name, temperature=0.0)
    return prompt | llm, parser

# ---- safer JSON extractor (balanced braces) ----
def _recover_json(text: str) -> str:
    txt = (text or "").strip()
    start = txt.find("{")
    if start < 0:
        return txt
    depth = 0
    for i in range(start, len(txt)):
        c = txt[i]
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
            if depth == 0:
                return txt[start:i+1]
    return txt[start:]  # fallback

def try_extract_inputs(chain, parser, code_text: str) -> Optional[ExtractSchema]:
  
    raw = chain.invoke({"code": code_text}).content
    if DEBUG:
        print("[DEBUG][LLM Raw Extract]", raw[:TRUNC].replace("\n", " ⏎ "))
    jr = _recover_json(raw)
    try:
        res = parser.parse(jr)
        if DEBUG:
            print("[DEBUG][Parsed Extract cases]", len(res.cases))
        return res if res.cases else None
    except Exception as e:
        if DEBUG:
            print("[DEBUG][Extract FAIL]", type(e).__name__, str(e)[:200])
        return None

def judge_equal(chain, parser, py_code: str, other_code: str, other_lang_label: str) -> str:
   
    q = (
        "Decide if the following TWO test suites use the SAME INPUTS.\n\n"
        "=== Python Test Code ===\n" + py_code + "\n\n"
        f"=== {other_lang_label} Test Code ===\n" + other_code + "\n\n"
        'Answer ONLY as {"answer":"Equal"} or {"answer":"Not_Equal"}.'
    )
    raw = chain.invoke({"question": q}).content
    if DEBUG:
        print("[DEBUG][LLM Raw Judge]", raw[:TRUNC].replace("\n", " ⏎ "))
    verdict = parser.parse(_recover_json(raw)).answer
    return verdict


# =========================
# Input normalization & comparison
# =========================
def normalize_atom(s: str) -> str:
    x = s.strip().lower()
    x = re.sub(r'\s*,\s*', ', ', x)
    x = re.sub(r'\bnone\b|\bnull\b|\bundefined\b', 'null', x)
    if re.fullmatch(r"'[^']*'|\"[^\"]*\"", x):
        x = x[1:-1]
    return x

def normalize_case(args: List[str]) -> Tuple[str, ...]:
    return tuple(normalize_atom(a) for a in args)

def multiset(lst):
    return Counter(lst)

def compare_extracted(py_cases: List[List[str]], other_cases: List[List[str]]) -> Tuple[bool, List[Tuple], List[Tuple]]:
    py_norm = [normalize_case(c) for c in py_cases]
    ot_norm = [normalize_case(c) for c in other_cases]
    A, B = multiset(py_norm), multiset(ot_norm)
    return (A == B), list((A - B).elements()), list((B - A).elements())

# =========================
# Utilities
# =========================
def is_windows() -> bool:
    return os.name == "nt"

def cp_sep() -> str:
    return ";" if is_windows() else ":"

# =========================
# Test execution
# =========================
def run_python_test(path: str, timeout: int = PY_TIMEOUT) -> Tuple[bool, str, str]:
    try:
        cp = subprocess.run(["python", path], text=True, capture_output=True, timeout=timeout)
        return cp.returncode == 0, cp.stdout, cp.stderr
    except Exception as e:
        return False, "", str(e)

def run_js_test(path: str, timeout: int = JS_TIMEOUT) -> Tuple[bool, str, str]:
    try:
        cwd = os.path.dirname(path)
        fname = os.path.basename(path)
        cp = subprocess.run(["npx", "jest", fname], cwd=cwd or None, text=True, capture_output=True, timeout=timeout)
        return cp.returncode == 0, cp.stdout, cp.stderr
    except Exception as e:
        return False, "", str(e)

def infer_classes_dir_from_target(target_test: str) -> str:
    """
    - If target_test is a file, returns the nearest ancestor directory named 'classes',
      otherwise returns the parent directory.
    - If target_test is a directory, returns the directory itself.
    """
    p = Path(target_test)
    if p.is_dir():
        return str(p.resolve())
    for anc in p.parents:
        if anc.name == "classes":
            return str(anc.resolve())
    return str(p.parent.resolve())

def find_java_sources(root: str) -> List[str]:
    root_p = Path(root)
    return [str(p) for p in root_p.rglob("*.java")]

def filter_javac_noise(s: str) -> str:
    """Hide common benign notes like 'uses unchecked or unsafe operations'."""
    if not s:
        return s
    drop_patterns = [
        r"^Note: .* uses unchecked or unsafe operations\.\s*$",
        r"^Note: Recompile with -Xlint:unchecked for details\.\s*$",
    ]
    drop_res = [re.compile(p) for p in drop_patterns]
    kept = []
    for line in s.splitlines():
        if any(r.search(line) for r in drop_res):
            continue
        kept.append(line)
    return "\n".join(kept).strip()

def compile_java_sources(classes_dir: str, junit_jar: str, extra_classpath: Optional[str] = None,
                         timeout: int = JAVAC_TIMEOUT) -> Tuple[bool, str, str]:
    """
    Compile all .java files under classes_dir, output .class into classes_dir.
    Classpath: classes_dir + junit_jar (+ extra)
    Suppresses noisy notes/warnings by default.
    """
    sources = find_java_sources(classes_dir)
    if not sources:
        return True, "", ""  # nothing to compile

    cp = cp_sep().join(filter(None, [classes_dir, junit_jar, extra_classpath]))
    cmd = [
        "javac",
        "-cp", cp,
        "-d", classes_dir,
        "-nowarn",             # suppress warnings & notes
        "-Xlint:-unchecked",   # explicitly disable 'unchecked' category
    ] + sources

    try:
        cp_res = subprocess.run(cmd, text=True, capture_output=True, timeout=timeout)
        ok = (cp_res.returncode == 0)
        return ok, cp_res.stdout, cp_res.stderr
    except Exception as e:
        return False, "", f"{type(e).__name__}: {e}"

def run_java_test_scan(classes_dir: str, junit_jar: str, timeout: int = JAVA_TIMEOUT) -> Tuple[bool, str, str]:
    cmd = [
        "java", "-jar", junit_jar,
        "execute",
        "--class-path", classes_dir,
        "--scan-class-path",
        "--details", "tree",
    ]
    try:
        cp = subprocess.run(cmd, text=True, capture_output=True, timeout=timeout)
        return cp.returncode == 0, cp.stdout, cp.stderr
    except Exception as e:
        return False, "", f"{type(e).__name__}: {e}"

# =========================
# Main
# =========================
def main():
    ap = argparse.ArgumentParser(description="Compare Python vs JS/Java tests (single pair)")
    # positional with defaults via env + nargs='?'
    ap.add_argument(
        "python_test",
        type=str,
        nargs="?",
        default=os.environ.get("PY_TEST", "./data/test-py/0.py"),
        help="Python test file (default: ./data/test-py/0.py or $PY_TEST)"
    )
    ap.add_argument(
        "target_test",
        type=str,
        nargs="?",
        default=os.environ.get("TARGET_TEST", "./result/qwen/32b-test-java/run_0/classes/HumanEval_0.java"),
        help="Other test file (Java or JS) (default: ./result/qwen/32b-test-java/run_0/classes/HumanEval_0.java or $TARGET_TEST)"
    )
    ap.add_argument(
        "target_lang",
        nargs="?",
        choices=["js", "java"],
        default=os.environ.get("TARGET_LANG", "java"),
        help='Target language ("js" or "java") (default: java or $TARGET_LANG)'
    )
    ap.add_argument(
        "--junit_jar",
        type=str,
        default=os.environ.get("JUNIT_JAR", "./data/junit.jar"),
        help="JUnit standalone JAR (for Java) (default: ./data/junit.jar or $JUNIT_JAR)"
    )
    ap.add_argument(
        "--classes_dir",
        type=str,
        default=os.environ.get("CLASSES_DIR"),  # will be inferred from target_test if missing
        help="Compiled classes dir (for Java). If omitted, inferred from target_test."
    )
    ap.add_argument(
        "--no_compile_java",
        action="store_true",
        help="Skip compiling Java sources before running JUnit."
    )

    ap.add_argument("--debug", action="store_true", help="Print concise debug logs")

    args = ap.parse_args()

# --- Input comparison (LLM) ---
    extract_chain, extract_parser = build_extract_chain(MODEL_NAME)
    judge_chain, judge_parser = build_judge_chain(MODEL_NAME)

    with open(args.python_test, encoding="utf-8") as f:
        py_code = f.read()
    with open(args.target_test, encoding="utf-8") as f:
        other_code = f.read()

    # 1) 각 테스트에서 입력 추출 시도
    py_ex  = try_extract_inputs(extract_chain, extract_parser, py_code)
    ot_ex  = try_extract_inputs(extract_chain, extract_parser, other_code)

    # 2) 둘 다 추출 성공이면 멀티셋 비교, 하나라도 실패면 판사 모드
    if py_ex and ot_ex:
        eq, missing, extra = compare_extracted(py_ex.cases, ot_ex.cases)
        print("[INPUT Comparison]", "Equal" if eq else "Not Equal")
        if not eq:
            if missing: print("  Missing (only in Python):", missing)
            if extra:   print("  Extra    (only in Other):", extra)
        input_equal = eq
    else:
        other_label = "JavaScript" if args.target_lang == "js" else "Java"
        verdict = judge_equal(judge_chain, judge_parser, py_code, other_code, other_label)
        input_equal = (verdict == "Equal")
        print("[INPUT Comparison - judge]", verdict)

    # --- Run tests ---
    py_pass, _, _ = run_python_test(args.python_test)

    if args.target_lang == "js":
        other_pass, _, _ = run_js_test(args.target_test)
    else:
        classes_dir = args.classes_dir or infer_classes_dir_from_target(args.target_test)
        if not args.junit_jar or not classes_dir:
            print("Error: --junit_jar or classes_dir missing for Java")
            return

        # Compile Java (unless skipped)
        if not args.no_compile_java:
            ok, out, err = compile_java_sources(classes_dir=classes_dir, junit_jar=args.junit_jar)
            print("[JAVA Compile]", "OK" if ok else "FAILED")

            # 성공 시에는 조용히, 실패하거나 --debug일 때만 상세 출력
            if (DEBUG or not ok):
                ferr = filter_javac_noise(err)
                if DEBUG and out.strip():
                    print("  stdout:", out.strip()[:TRUNC])
                if ferr:
                    print("  stderr:", ferr[:TRUNC])

            if not ok:
                other_pass = False
                print("[OUTPUT Comparison] Not Equal (python_pass=%s, other_pass=%s)" % (py_pass, other_pass))
                print("[Execution Results] => Failure (Java compile failed)")
                return

        other_pass, _, _ = run_java_test_scan(classes_dir, args.junit_jar)

    # --- Output comparison (returncode equivalence) ---
    output_equal = (py_pass == other_pass)
    print(f"[OUTPUT Comparison] {'Equal' if output_equal else 'Not Equal'} (python_pass={py_pass}, other_pass={other_pass})")

    # --- Overall notice (kept for continuity) ---
    if py_pass and other_pass:
        notice = "Success"
    elif py_pass and not other_pass:
        notice = "Failure"
    elif not py_pass and other_pass:
        notice = "Abnormal"
    else:
        notice = "Invalid"
    print("[Execution Results] =>", notice)

if __name__ == "__main__":
    main()
