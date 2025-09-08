import os
import re
import json
import random
import shutil
import subprocess
from argparse import ArgumentParser
from typing import TypedDict, Optional, Dict, Any, List, Tuple  # ← Tuple 추가

import numpy as np
import torch

from langchain_ollama import ChatOllama
from langgraph.graph import StateGraph, END
from langchain_core.prompts import ChatPromptTemplate


# =========================
# 유틸
# =========================
def set_seed(seed: int):
    random.seed(seed)
    np.random.seed(seed)
    torch.manual_seed(seed)
    torch.cuda.manual_seed(seed)
    torch.cuda.manual_seed_all(seed)


def is_windows() -> bool:
    return os.name == "nt"


def cp_sep() -> str:
    return ";" if is_windows() else ":"


def ensure_dir(path: str):
    os.makedirs(path, exist_ok=True)


def read_file(path: str) -> str:
    with open(path, "r", encoding="utf-8") as f:
        return f.read()


def write_file(path: str, text: str):
    ensure_dir(os.path.dirname(path))
    with open(path, "w", encoding="utf-8") as f:
        f.write(text)


def list_indexed_files(dir_path: str) -> Dict[int, str]:
    """
    파일명 안의 숫자를 인덱스로 인식.
    우선순위:
      1) 확장자 앞의 숫자 (예: human_eval_12.java -> 12)
      2) 파일명 어디서든 처음 나오는 숫자 (예: foo9_bar.txt -> 9)
    동일 인덱스가 여러 개인 경우, 사전순으로 가장 앞 파일을 선택.
    """
    out: Dict[int, str] = {}
    if not os.path.isdir(dir_path):
        return out

    candidates: List[Tuple[int, str, str]] = []  # (idx, fname, fullpath)
    for fname in os.listdir(dir_path):
        fpath = os.path.join(dir_path, fname)
        if not os.path.isfile(fpath):
            continue

        # 1) 확장자 앞 숫자 우선 매칭: *_<digits>.<ext> 또는 *digits.<ext>
        m = re.search(r"(\d+)(?=\.[^.]+$)", fname)
        if not m:
            # 2) 파일명 내 아무 숫자
            m = re.search(r"(\d+)", fname)
        if not m:
            continue

        idx = int(m.group(1))
        candidates.append((idx, fname, fpath))

    candidates.sort(key=lambda x: (x[0], x[1]))
    for idx, fname, fpath in candidates:
        if idx not in out:
            out[idx] = fpath
    return out



def align_triplets(
    source_map: Dict[int, str],
    transform_map: Dict[int, str],
    test_map: Dict[int, str],
) -> List[Tuple[int, str, str, str]]:
    
    common = sorted(set(source_map.keys()) & set(transform_map.keys()) & set(test_map.keys()))
    out: List[Tuple[int, str, str, str]] = []
    for i in common:
        out.append((i, source_map[i], transform_map[i], test_map[i]))
    return out


def extract_codeblock(text: str, langs=("java", "")) -> str:

    blocks = []
    for lang in langs:
        if lang:
            pat = rf"```{lang}\s+(.*?)```"
        else:
            pat = r"```\s+(.*?)```"
        blocks += re.findall(pat, text, flags=re.DOTALL)
    if not blocks:
        return text.strip()
    return max(blocks, key=len).strip()


def extract_public_class_name(java_code: str) -> Optional[str]:
    m = re.search(r"public\s+(?:final\s+|abstract\s+)?class\s+([A-Za-z_]\w*)", java_code)
    return m.group(1) if m else None


def extract_package(java_code: str) -> Optional[str]:
    m = re.search(r"^\s*package\s+([A-Za-z_]\w*(?:\.[A-Za-z_]\w*)*)\s*;", java_code, re.MULTILINE)
    return m.group(1) if m else None


def package_to_dir(base_dir: str, pkg: Optional[str]) -> str:
    if not pkg:
        ensure_dir(base_dir)
        return base_dir
    rel = pkg.replace(".", os.sep)
    dst = os.path.join(base_dir, rel)
    ensure_dir(dst)
    return dst


def extract_test_cases_hint(source_code: str) -> str:
    # 기존 JS 파이프라인과 유사한 힌트 추출: 첫 class 앞의 직전 줄부터 끝까지
    lines = source_code.split("\n")
    start_idx = 0
    for i, line in enumerate(lines):
        if line.strip().startswith("class"):
            start_idx = i - 1
    return "\n".join(lines[start_idx:])


def run_cmd(cmd: List[str], timeout: int = 30) -> subprocess.CompletedProcess:
    return subprocess.run(cmd, capture_output=True, text=True, timeout=timeout)


def normalize_test_class(code: str, idx: int) -> Tuple[str, str]:

    class_name = f"human_eval_{idx}"

    if re.search(r"\bpublic\s+class\s+\w+\b", code):
        code = re.sub(r"\bpublic\s+class\s+\w+\b", f"public class {class_name}", code, count=1)
    elif re.search(r"\bclass\s+\w+\b", code):
        code = re.sub(r"\bclass\s+\w+\b", f"class {class_name}", code, count=1)
    else:
        header = (
            "import org.junit.jupiter.api.*;\n"
            "import static org.junit.jupiter.api.Assertions.*;\n\n"
        )
        code = f"{header}public class {class_name} {{\n{code}\n}}\n"

    return code, class_name


def route_after_run(state: "State") -> str:
    return "analyze_failure" if state.get("is_failure") else "end"

def route_after_analyze(state: "State") -> str:
    if state.get("retry_count", 0) >= 3:
        return "end"
    return "revise_test_cases" if state.get("failure_responding") == "revise_test_cases" else "end"



class State(TypedDict):
    source_code: str          
    transformed_code: str      
    source_test_cases: str     
    generated_test_code: str   
    compile_stdout: str
    compile_stderr: str
    run_stdout: str
    run_stderr: str
    retry_count: int
    is_failure: bool
    failure_analysis: str
    failure_responding: str


def parse_args():
    parser = ArgumentParser()
    parser.add_argument("-sd", "--source_dir", type=str, default="./result/qwen/temp-py2java")
    parser.add_argument("-td", "--transform_dir", type=str, default="./result/qwen/temp-eq2java")
    parser.add_argument("-tcd", "--test_case_dir", type=str, default="./data/test-py")
    parser.add_argument("-od", "--output_dir", type=str, default="./result/qwen/java_test")

    parser.add_argument("--generate_test_prompt", type=str, default="./data/prompts/generate-java-test.txt")
    parser.add_argument("--analyze_test_prompt", type=str, default="./data/prompts/analyze-java-test.txt")
    parser.add_argument("--revise_test_prompt", type=str, default="./data/prompts/revise-java-test.txt")

    parser.add_argument("-m", "--model", type=str, default="qwen2.5-coder:32b-instruct-fp16")

    parser.add_argument("--seed", type=int, default=42)
    # 추가: JUnit5 standalone jar 위치
    parser.add_argument("--junit_jar", type=str, default="./data/junit.jar")

    return parser.parse_args()



def main(args):

    source_dir = args.source_dir if args.source_dir.endswith(os.sep) else args.source_dir + os.sep
    transform_dir = args.transform_dir if args.transform_dir.endswith(os.sep) else args.transform_dir + os.sep
    test_case_dir = args.test_case_dir if args.test_case_dir.endswith(os.sep) else args.test_case_dir + os.sep
    output_dir = args.output_dir if args.output_dir.endswith(os.sep) else args.output_dir + os.sep

    ensure_dir(output_dir)

    source_map = list_indexed_files(source_dir)
    transform_map = list_indexed_files(transform_dir)
    test_map = list_indexed_files(test_case_dir)
    triplets = align_triplets(source_map, transform_map, test_map)
    print("[DEBUG] source idx:", list(source_map.keys())[:10])
    print("[DEBUG] transform idx:", list(transform_map.keys())[:10])
    print("[DEBUG] test idx:", list(test_map.keys())[:10])
    print("[DEBUG] common triplets:", len(triplets))
    if not triplets:
        print("No common indices across source/transform/test. Check directory paths and file names.")
        return


    set_seed(args.seed)
    llm = ChatOllama(model=args.model, base_url="http://localhost:11434")


    gen_prompt = ChatPromptTemplate.from_template(
        read_file(args.generate_test_prompt),
        template_format="jinja2",   
    )
    ana_prompt = ChatPromptTemplate.from_template(
        read_file(args.analyze_test_prompt),
        template_format="jinja2",   # ← 추가
    )



    def generate_test_inputs(state: State) -> State:
        response = llm.invoke(
            gen_prompt.format_messages(
                source_code=state["source_code"],            
                transformed_code=state["transformed_code"],  
                test_cases=state["source_test_cases"],      
            )
        )
        code_block = extract_codeblock(response.content, langs=("java", ""))
        return {"generated_test_code": code_block}

    def write_and_compile(state: State) -> State:

        run_root = state["_run_root"] 
        idx = state["_idx"]
        classes_dir = os.path.join(run_root, "classes")
        ensure_dir(classes_dir)

 
        cut_code = state["transformed_code"]
        cut_pkg = extract_package(cut_code)
        cut_public = extract_public_class_name(cut_code) or "CutClass"
        cut_dir = package_to_dir(classes_dir, cut_pkg)
        cut_path = os.path.join(cut_dir, f"{cut_public}.java")
        write_file(cut_path, cut_code)

    
        test_code_raw = state["generated_test_code"]
        test_code_norm, class_name = normalize_test_class(test_code_raw, idx)
        test_pkg = extract_package(test_code_norm)  
        test_dir = package_to_dir(classes_dir, test_pkg)
        test_path = os.path.join(test_dir, f"{class_name}.java")
        write_file(test_path, test_code_norm)

    
        cp = cp_sep().join([classes_dir, args.junit_jar])
        java_files = []
        for root, _, files in os.walk(classes_dir):
            for name in files:
                if name.endswith(".java"):
                    java_files.append(os.path.join(root, name))

        cmd = ["javac", "-cp", cp] + java_files
        try:
            proc = run_cmd(cmd, timeout=40)
            compile_stdout, compile_stderr, rc = proc.stdout, proc.stderr, proc.returncode
        except subprocess.TimeoutExpired as e:
            compile_stdout, compile_stderr, rc = "", f"Compile timeout: {e}", 1

        return {
            "compile_stdout": compile_stdout,
            "compile_stderr": compile_stderr,
            "is_failure": rc != 0
        }

    def run_tests(state: State) -> State:
        if state["is_failure"]:
            return {"run_stdout": "", "run_stderr": "", "is_failure": True}

        run_root = state["_run_root"]
        classes_dir = os.path.join(run_root, "classes")

        cmd = [
            "java", "-jar", args.junit_jar,
            "-cp", classes_dir,
            "--scan-class-path"
        ]
        try:
            proc = run_cmd(cmd, timeout=45)
            run_stdout, run_stderr, rc = proc.stdout, proc.stderr, proc.returncode
        except subprocess.TimeoutExpired as e:
            run_stdout, run_stderr, rc = "", f"Run timeout: {e}", 1

        return {
            "run_stdout": run_stdout,
            "run_stderr": run_stderr,
            "is_failure": rc != 0
        }

    def analyze_failure(state: State) -> State:
        response = llm.invoke(
            ana_prompt.format_messages(
                test_cases=state["generated_test_code"],
                test_result=(state.get("compile_stderr", "") + "\n" +
                             state.get("run_stdout", "") + "\n" +
                             state.get("run_stderr", "")),
            )
        )
        analysis = response.content.strip()

        next_step = "end"
        for line in analysis.splitlines():
            if "Action" in line and "Revise" in line:
                next_step = "revise_test_cases"
                break

        return {"failure_analysis": analysis, "failure_responding": next_step}

    def revise_test_cases(state: State) -> State:
        response = llm.invoke(
            ChatPromptTemplate.from_template(
                read_file(args.revise_test_prompt),
                template_format="jinja2",  
            ).format_messages(
                test_cases=state["generated_test_code"],
                failure_analysis=state["failure_analysis"],
            )
        )
        code_block = extract_codeblock(response.content, langs=("java", ""))
        return {"generated_test_code": code_block, "retry_count": state["retry_count"] + 1}

    workflow = StateGraph(State)
    workflow.add_node("generate_test_inputs", generate_test_inputs)
    workflow.add_node("write_and_compile", write_and_compile)
    workflow.add_node("run_tests", run_tests)
    workflow.add_node("analyze_failure", analyze_failure)
    workflow.add_node("revise_test_cases", revise_test_cases)

    workflow.set_entry_point("generate_test_inputs")
    workflow.add_edge("generate_test_inputs", "write_and_compile")
    workflow.add_edge("write_and_compile", "run_tests")
    workflow.add_conditional_edges(
        "run_tests",
        route_after_run,
        {
            "analyze_failure": "analyze_failure",
            "end": END,
        },
    )

    workflow.add_conditional_edges(
        "analyze_failure",
        route_after_analyze,
        {
            "revise_test_cases": "revise_test_cases",
            "end": END,
        },
    )

    workflow.add_edge("revise_test_cases", "write_and_compile")

    graph = workflow.compile()

    for idx, src_path, trans_path, test_hint_path in triplets:
        print(f"--- {idx} ---")
        run_root = os.path.join(output_dir, f"run_{idx}")
        if os.path.exists(run_root):
            shutil.rmtree(run_root)
        ensure_dir(run_root)

        source_code = read_file(src_path)
        transformed_code = read_file(trans_path)
        source_test_hint_raw = read_file(test_hint_path)
        source_test_hint = extract_test_cases_hint(source_test_hint_raw)

        initial_state: State = {
            "source_code": source_code,
            "transformed_code": transformed_code,
            "source_test_cases": source_test_hint,
            "generated_test_code": "",
            "compile_stdout": "",
            "compile_stderr": "",
            "run_stdout": "",
            "run_stderr": "",
            "retry_count": 0,
            "is_failure": False,
            "failure_analysis": "",
            "failure_responding": "end",


            "_run_root": run_root,  
            "_idx": idx,            
        } 

        result: Dict[str, Any] = graph.invoke(initial_state)

    
        result_to_save = dict(result)
        result_to_save["index"] = idx
 
        result_to_save.pop("_run_root", None)

        write_file(os.path.join(output_dir, "report.txt"), json.dumps(result_to_save, ensure_ascii=False) + "\n")


        print("[compile stderr]")
        print(result.get("compile_stderr", ""))
        print("[run stdout]")
        print(result.get("run_stdout", ""))
        print("[run stderr]")
        print(result.get("run_stderr", ""))
        print("[analysis]")
        print(result.get("failure_analysis", ""))
        print("-------")


if __name__ == "__main__":
    args = parse_args()
    set_seed(args.seed)
    main(args)
