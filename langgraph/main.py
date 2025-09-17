import os
import re
import json
import random
import shutil
import subprocess
from typing import TypedDict

import torch

from transformers import (
    AutoTokenizer, AutoModelForCausalLM
)

from langchain_ollama import ChatOllama
from langgraph.graph import StateGraph, END
from langchain_core.prompts import ChatPromptTemplate
from langchain_teddynote import logging

from generate_equiv import extract_code_block
from generate_test_js import extract_test_cases

from typing import TypedDict, Optional, Dict, Any, List, Tuple

# =========================
# OpenAI-compatible adapter (추가)
# =========================
from openai import OpenAI
import httpx
from types import SimpleNamespace
from langchain_core.messages import BaseMessage, SystemMessage, HumanMessage, AIMessage

def _lc_messages_to_openai(messages: List[BaseMessage]) -> List[Dict[str, str]]:
    """LangChain Message -> OpenAI /v1 chat messages 로 변환"""
    out: List[Dict[str, str]] = []
    for m in messages:
        if isinstance(m, SystemMessage):
            out.append({"role": "system", "content": m.content})
        elif isinstance(m, HumanMessage):
            out.append({"role": "user", "content": m.content})
        else:
            # 기타 타입은 assistant 로 처리
            out.append({"role": "assistant", "content": m.content})
    return out

class OpenAICompat:
    """
    OpenAI Python SDK로 /v1/chat/completions 호출.
    ChatOllama와 동일하게 .invoke(messages) -> SimpleNamespace(content=...) 형태를 제공합니다.
    """
    def __init__(self, model: str, base_url: str, api_key: str, timeout: int = 120, temperature: float = 0.0):
        base_url = base_url.rstrip("/")
        if not base_url.endswith("/v1"):
            base_url = base_url + "/v1"
        self.client = OpenAI(
            base_url=base_url,
            api_key=api_key,
            http_client=httpx.Client(timeout=timeout),
        )
        self.model = model
        self.temperature = temperature

    def invoke(self, messages: List[BaseMessage]) -> SimpleNamespace:
        payload = {
            "model": self.model,
            "messages": _lc_messages_to_openai(messages),
            "temperature": self.temperature,
        }
        resp = self.client.chat.completions.create(**payload)
        content = resp.choices[0].message.content or ""
        return SimpleNamespace(content=content)

# =========================
# 원본 로직 + compat 옵션만 추가
# =========================

def sem_equiv_test(
    origin_code: str = None,
    generate_equiv_model: str = None,
    generate_test_model: str = None,
    temperature: float = 1.0,

    # ---- OpenAI-compatible 옵션 (추가) ----
    generate_test_backend: str = "ollama",          # "ollama"(기본) 또는 "openai"
    openai_base_url: str = "http://localhost:11434/v1",
    openai_api_key: str = "EMPTY",
    llm_timeout: int = 120,
):
    """
    1. 입력된 소스 코드의 동등 변형 생성 (HF transformers)
    2. 동등성 검증용 테스트 케이스 생성 (Ollama 기본, 필요 시 OpenAI 호환)
    """
    tokenizer = AutoTokenizer.from_pretrained(generate_equiv_model)
    model = AutoModelForCausalLM.from_pretrained(generate_equiv_model, device_map="auto", load_in_8bit=True)
    model.eval()
    
    system = open("./data/prompts/generate-equiv-system.txt", 'r').read()
    user = open("./data/prompts/generate-equiv-user.txt", 'r').read()
    
    examples = json.load(open("./data/prompts/examples.json", 'r'))["Python"]
    
    # 동등변형 코드 생성
    messages = [
        {"role": "system", "content": system},
        {"role": "user", "content": user.format(source_example=examples["Source"], target_example=examples["Target"], language="python", source=origin_code)}
    ]
    
    inputs = tokenizer.apply_chat_template(messages, tokenize=False, add_generation_prompt=True)
    model_inputs = tokenizer([inputs], return_tensors="pt")

    input_ids = model_inputs.input_ids
    attention_mask = model_inputs.attention_mask

    with torch.no_grad():
        output_ids = model.generate(
            input_ids=input_ids,
            attention_mask=attention_mask,
            max_new_tokens=512,
            temperature=temperature,
        )
        
    responses = tokenizer.batch_decode([
        output_id[len(input_id):] for input_id, output_id in zip(input_ids, output_ids)
    ], skip_special_tokens=True)
    
    equiv_code = extract_code_block(responses[0])
    
    del model, input_ids, attention_mask
    torch.cuda.empty_cache()
    
    # 테스트 케이스 생성 LLM: 기본 Ollama, 선택적으로 OpenAI 호환
    if generate_test_backend == "openai":
        llm = OpenAICompat(
            model=generate_test_model,
            base_url=openai_base_url,
            api_key=openai_api_key,
            timeout=llm_timeout,
            temperature=temperature,
        )
    else:
        llm = ChatOllama(model=generate_test_model, base_url="http://localhost:11434")
    
    generate_test_prompt = "./data/prompts/generate-py-test.txt"
    analyze_test_prompt = "./data/prompts/analyze-py-test.txt"
    generate_equiv_prompt = "./data/prompts/generate-equiv-user.txt"
    revise_test_prompt = "./data/prompts/revise-py-test.txt"
        
    class State(TypedDict):
        source_code: str
        transformed_code: str
        test_cases: str
        retry_count: int
        test_result: str
        is_failure: bool
        failure_analysis: str
        failure_responding: str
    
    # node
    def generate_test_inputs(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(generate_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                source_code=state["source_code"],
                transformed_code=state["transformed_code"]
            ),
        )
        
        code_blocks = re.findall(r"```(?:python)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        
        return {"test_cases": code_block}
    
    # node
    def run_test_cases(state: State) -> State:
        try:
            with open(".tmp.py", 'w') as f:
                f.write(state["test_cases"])
            
            result = subprocess.run(
                ["python", ".tmp.py"],
                text=True,
                capture_output=True,
                timeout = 5
            )
        except Exception as e:
            result = subprocess.CompletedProcess(args=["python"], returncode=1, stdout="", stderr=str(e))
    
        subprocess.run(["rm", ".tmp.py"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    
        if result.returncode == 0 or state["retry_count"] == 3:
            return {"test_result": result.stdout, "is_failure": False}
        else:
            return {"test_result": result.stderr, "is_failure": True, "retry_count": state["retry_count"] + 1}
    
    # node
    def analyze_failure(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(analyze_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                test_cases=state["test_cases"],
                test_result=state["test_result"]
            ),
        )
        
        lines = response.content.split("\n")
        failure_responding = END
        for line in lines:
            if "Action" in line.strip() and "Revise" in line.strip():
                if "transformed code" in line: failure_responding = "revise_transformed_code"
                elif "test cases" in line: failure_responding = "revise_test_cases"
        
        return {"failure_analysis": response.content.strip(), "failure_responding": failure_responding}
    
    # node
    def revise_transformed_code(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(generate_equiv_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                source=state["source_code"]
            )
        )
        
        code_blocks = re.findall(r"```(?:python)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        
        return {"transformed_code": code_block}
    
    # node
    def revise_test_cases(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(revise_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                test_cases=state["test_cases"],
                failure_analysis=state["failure_analysis"]
            )
        )
        
        code_blocks = re.findall(r"```(?:python)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        
        return {"test_cases": code_block}
    
    workflow = StateGraph(State)
    
    workflow.add_node("generate_test_inputs", generate_test_inputs)
    workflow.add_node("run_test_cases", run_test_cases)
    workflow.add_node("analyze_failure", analyze_failure)
    workflow.add_node("revise_transformed_code", revise_transformed_code)
    workflow.add_node("revise_test_cases", revise_test_cases)
    
    workflow.set_entry_point("generate_test_inputs")
    workflow.add_edge("generate_test_inputs", "run_test_cases")
    workflow.add_conditional_edges(
        "run_test_cases", lambda state: "analyze_failure" if state["is_failure"] else END,
        {"analyze_failure": "analyze_failure", END: END}
    )
    workflow.add_conditional_edges(
        "analyze_failure", lambda state: state["failure_responding"],
        {"revise_transformed_code": "revise_transformed_code", "revise_test_cases": "revise_test_cases", END: END}
    )
    workflow.add_edge("revise_transformed_code", "generate_test_inputs")
    workflow.add_edge("revise_test_cases", "run_test_cases")
    
    graph = workflow.compile()
    
    initial_state = {
        "source_code": origin_code,
        "transformed_code": equiv_code,
        "test_cases": "",
        "retry_count": 0,
    }
    
    result = graph.invoke(initial_state)
    if result.get("retry_count", 0) == 3:
        print("Failed to generate test cases.")
    
    print(result)
    
    return (equiv_code, result["test_cases"])

def generate_test_js(
    origin_target_code: str = None,
    sem_target_code: str = None,
    test_code: str = None,
    model_api: str = None,
    temperature: float = 1.0,

    # ---- OpenAI-compatible 옵션 (추가) ----
    backend: str = "ollama",                    # "ollama"(기본) 또는 "openai"
    base_url: str = "http://localhost:11434/v1",
    api_key: str = "EMPTY",
    llm_timeout: int = 120,
):
    """
    번역된 소스 코드와 동등 변형 코드 간 동등성 검증용 JS 테스트 케이스 생성.
    로직 동일, LLM 백엔드만 선택 가능.
    """
    if backend == "openai":
        llm = OpenAICompat(
            model=model_api,
            base_url=base_url,
            api_key=api_key,
            timeout=llm_timeout,
            temperature=temperature,
        )
    else:
        llm = ChatOllama(model=model_api, base_url="http://localhost:11434")
    
    generate_test_prompt = "./data/prompts/generate-js-test.txt"
    analyze_test_prompt = "./data/prompts/analyze-js-test.txt"
    revise_test_prompt = "./data/prompts/revise-js-test.txt"
    
    os.makedirs("./.tmp", exist_ok=True)
    
    subprocess.run(
        f"cd ./.tmp; npm init -y", shell=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL
    )
    subprocess.run(
        f"cd ./.tmp; npm install --save-dev jest", shell=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL
    )

    class State(TypedDict):
        source_code: str
        transformed_code: str
        source_test_cases: str
        test_cases: str
        retry_count: int
        test_result: str
        is_failure: bool
        failure_analysis: str
        failure_responding: str
    
    # node
    def generate_test_inputs(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(generate_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                source_code=state["source_code"],
                transformed_code=state["transformed_code"],
                test_cases=state["source_test_cases"]
            ),
        )
        
        code_blocks = re.findall(r"```(?:javascript)?\n(.*?)```", response.content, re.DOTALL)
        if len(code_blocks) == 0:
            code_blocks = [response.content]
        code_block = max(code_blocks, key=len).strip()
        
        return {"test_cases": code_block}
    
    # node
    def run_test_cases(state: State) -> State:
        try:
            with open("./.tmp/code.test.js", 'w') as f:
                f.write(state["test_cases"])
            
            result = subprocess.run(
                f"cd ./.tmp; npx jest code.test.js",
                shell=True,
                text=True,
                capture_output=True,
                timeout = 5
            )
        except Exception as e:
            result = subprocess.CompletedProcess(args=["npx"], returncode=1, stdout="", stderr=str(e))

        subprocess.run(["rm", "./.tmp/code.test.js"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

        if result.returncode == 0:
            return {"test_result": result.stdout, "is_failure": False}
        else:
            if state["retry_count"] == 3:
                return {"test_result": result.stderr, "is_failure": False, "retry_count": state["retry_count"] + 1}
            else:
                return {"test_result": result.stderr, "is_failure": True, "retry_count": state["retry_count"] + 1}
    
    # node
    def analyze_failure(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(analyze_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                test_cases=state["test_cases"],
                test_result=state["test_result"]
            ),
        )
        
        lines = response.content.split("\n")
        failure_responding = END
        for line in lines:
            if "Action" in line.strip():
                if "Revise" in line: failure_responding = "revise_test_cases"
        
        return {"failure_analysis": response.content.strip(), "failure_responding": failure_responding}
    
    # node
    def revise_test_cases(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(revise_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                test_cases=state["test_cases"],
                failure_analysis=state["failure_analysis"]
            )
        )
        
        code_blocks = re.findall(r"```(?:javascript)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        
        return {"test_cases": code_block}
    
    workflow = StateGraph(State)
    
    workflow.add_node("generate_test_inputs", generate_test_inputs)
    workflow.add_node("run_test_cases", run_test_cases)
    workflow.add_node("analyze_failure", analyze_failure)
    workflow.add_node("revise_test_cases", revise_test_cases)
    
    workflow.set_entry_point("generate_test_inputs")
    workflow.add_edge("generate_test_inputs", "run_test_cases")
    workflow.add_conditional_edges(
        "run_test_cases", lambda state: "analyze_failure" if state["is_failure"] else END,
        {"analyze_failure": "analyze_failure", END: END}
    )
    workflow.add_conditional_edges(
        "analyze_failure", lambda state: state["failure_responding"],
        {"revise_test_cases": "revise_test_cases", END: END}
    )
    workflow.add_edge("revise_test_cases", "run_test_cases")
    
    graph = workflow.compile()
    
    initial_state = {
        "source_code": origin_target_code,
        "transformed_code": sem_target_code,
        "source_test_cases": extract_test_cases(test_code),
        "test_cases": "",
        "retry_count": 0,
    }
    
    result = graph.invoke(initial_state)
    if result.get("retry_count", 0) == 4:
        print("Failed to generate test cases")

    print(result)
    subprocess.run(["rm", "-rf" "./.tmp"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    
    return result["test_cases"]

def generate_test_java(
    origin_target_code: str = None,
    sem_target_code: str = None,
    test_code: str = None,
    model_api: str = None,
    temperature: float = 1.0,

    # ---- OpenAI-compatible 옵션 (추가) ----
    backend: str = "ollama",                    # "ollama"(기본) 또는 "openai"
    base_url: str = "http://localhost:11434/v1",
    api_key: str = "EMPTY",
    llm_timeout: int = 120,
):
    """
    Java(JUnit) 테스트 코드 생성 파이프라인 — 로직 동일, LLM 백엔드만 선택 가능.
    """
    if backend == "openai":
        llm = OpenAICompat(
            model=model_api,
            base_url=base_url,
            api_key=api_key,
            timeout=llm_timeout,
            temperature=temperature,
        )
    else:
        llm = ChatOllama(model=model_api, base_url="http://localhost:11434")

    generate_test_prompt = "./data/prompts/generate-java-test.txt"
    analyze_test_prompt = "./data/prompts/analyze-java-test.txt"
    revise_test_prompt = "./data/prompts/revise-java-test.txt"
    junit_jar = "./data/junit.jar"
    idx = 0
    
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
        error_type: str  # "compile", "runtime", "timeout", ""
        failure_analysis: str
        failure_responding: str
        _run_root: os.PathLike
        _idx: int
    
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

    def render_prompt_jinja2(path: str, **vars):
        tpl = read_file(path)
        return ChatPromptTemplate.from_template(tpl, template_format="jinja2").format_messages(**vars)

    def extract_codeblock(text: str, langs=("java", "")) -> str:
        blocks = []
        for lang in langs:
            if lang:
                pat = rf"```{lang}\s*(.*?)```"
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
        lines = source_code.split("\n")
        start_idx = 0
        for i, line in enumerate(lines):
            if line.strip().startswith("class"):
                start_idx = max(0, i - 1)
                break
        return "\n".join(lines[start_idx:])

    def run_cmd(cmd: List[str], timeout: int = 30) -> subprocess.CompletedProcess:
        return subprocess.run(cmd, capture_output=True, text=True, timeout=timeout)

    def _ensure_imports_for_junit(code: str) -> str:
        needed = [
            "import org.junit.jupiter.api.*;",
            "import org.junit.jupiter.params.*;",
            "import org.junit.jupiter.params.provider.*;",
            "import static org.junit.jupiter.api.Assertions.*;",
            "import java.util.stream.*;",
            "import java.util.*;",
        ]
        for imp in needed:
            if imp not in code:
                code = imp + "\n" + code
        return code

    def normalize_test_class(code: str, idx: int) -> Tuple[str, str]:
        """테스트 클래스를 정규화하고 필요한 import 추가"""
        class_name = f"HumanEval_{idx}"

        if re.search(r"\bpublic\s+class\s+\w+\b", code):
            code = re.sub(r"\bpublic\s+class\s+\w+\b", f"public class {class_name}", code, count=1)
        elif re.search(r"\bclass\s+\w+\b", code):
            code = re.sub(r"\bclass\s+\w+\b", f"class {class_name}", code, count=1)
        else:
            header = (
                "import org.junit.jupiter.api.*;\n"
                "import org.junit.jupiter.params.*;\n"
                "import org.junit.jupiter.params.provider.*;\n"
                "import static org.junit.jupiter.api.Assertions.*;\n"
                "import java.util.stream.*;\n"
                "import java.util.*;\n\n"
            )
            code = f"{header}public class {class_name} {{\n{code}\n}}\n"

        code = _ensure_imports_for_junit(code)
        return code, class_name

    def route_after_run(state: "State") -> str:
        return "analyze_failure" if state.get("is_failure") else "end"

    def route_after_analyze(state: "State") -> str:
        if state.get("retry_count", 0) >= 3:
            return "end"
        return "revise_test_cases" if state.get("failure_responding") == "revise_test_cases" else "end"

    def generate_test_inputs(state: "State") -> "State":
        """LLM을 사용해 테스트 코드 생성"""
        try:
            print("[DEBUG] Generating initial test code...")

            messages = render_prompt_jinja2(
                generate_test_prompt,
                source_code=state["source_code"],
                transformed_code=state["transformed_code"],
                test_cases=state["source_test_cases"],
            )

            response = llm.invoke(messages)
            code_block = extract_codeblock(response.content, langs=("java", ""))
            print(f"[DEBUG] Generated test code length: {len(code_block)}")
            return {"generated_test_code": code_block}
        except Exception as e:
            print(f"[ERROR] LLM generation failed: {e}")
            return {"generated_test_code": "", "is_failure": True, "error_type": "generation"}

    def write_and_compile(state: "State") -> "State":
        """테스트 코드와 CUT를 파일로 쓰고 컴파일"""
        run_root = state["_run_root"]
        idx = state["_idx"]
        classes_dir = os.path.join(run_root, "classes")
        ensure_dir(classes_dir)

        # CUT 작성
        cut_code = state["transformed_code"]
        cut_pkg = extract_package(cut_code)
        cut_public = extract_public_class_name(cut_code) or "CutClass"
        cut_dir = package_to_dir(classes_dir, cut_pkg)
        cut_path = os.path.join(cut_dir, f"{cut_public}.java")
        write_file(cut_path, cut_code)
    
        # 테스트 코드 작성
        test_code_raw = state["generated_test_code"]
        if not test_code_raw:
            return {
                "compile_stdout": "",
                "compile_stderr": "No test code generated",
                "is_failure": True,
                "error_type": "generation"
            }
        
        print(f"[DEBUG] Writing test code (retry: {state.get('retry_count', 0)})")
        test_code_norm, class_name = normalize_test_class(test_code_raw, idx)
        test_pkg = extract_package(test_code_norm)
        test_dir = package_to_dir(classes_dir, test_pkg)
        test_path = os.path.join(test_dir, f"{class_name}.java")
        write_file(test_path, test_code_norm)

        # 컴파일
        cp = cp_sep().join([classes_dir, junit_jar])
        java_files = []
        for root, _, files in os.walk(classes_dir):
            for name in files:
                if name.endswith(".java"):
                    java_files.append(os.path.join(root, name))

        cmd = ["javac", "-cp", cp, "-d", classes_dir] + java_files
        try:
            proc = run_cmd(cmd, timeout=40)
            compile_stdout, compile_stderr, rc = proc.stdout, proc.stderr, proc.returncode
            error_type = "compile" if rc != 0 else ""
        except subprocess.TimeoutExpired as e:
            compile_stdout, compile_stderr, rc = "", f"Compile timeout: {e}", 1
            error_type = "timeout"

        return {
            "compile_stdout": compile_stdout,
            "compile_stderr": compile_stderr,
            "is_failure": rc != 0,
            "error_type": error_type,
        }

    def run_tests(state: "State") -> "State":
        """JUnit 테스트 실행"""
        if state["is_failure"]:
            return {"run_stdout": "", "run_stderr": "Skipped due to compile failure", "is_failure": True}

        run_root = state["_run_root"]
        classes_dir = os.path.join(run_root, "classes")

        cmd = [
            "java", "-jar", junit_jar,
            "execute",
            "--class-path", classes_dir,
            "--scan-class-path",
            "--details", "tree",
        ]
        
        try:
            proc = run_cmd(cmd, timeout=45)
            run_stdout, run_stderr, rc = proc.stdout, proc.stderr, proc.returncode
            error_type = "runtime" if rc != 0 else ""
        except subprocess.TimeoutExpired as e:
            run_stdout, run_stderr, rc = "", f"Run timeout: {e}", 1
            error_type = "timeout"

        return {
            "run_stdout": run_stdout,
            "run_stderr": run_stderr,
            "is_failure": rc != 0,
            "error_type": error_type,
        }

    def analyze_failure(state: "State") -> "State":
        """실패 분석 및 다음 액션 결정"""
        try:
            print(f"[DEBUG] Analyzing failure (retry: {state.get('retry_count', 0)})")
            current_test_code = state.get("generated_test_code", "")
            print(f"[DEBUG] Current test code length: {len(current_test_code)}")

            test_result = (
                "=== Compile Output ===\n"
                f"{state.get('compile_stdout', '')}\n"
                f"{state.get('compile_stderr', '')}\n"
                "=== Run Output ===\n"
                f"{state.get('run_stdout', '')}\n"
                f"{state.get('run_stderr', '')}\n"
            )

            messages = render_prompt_jinja2(
                analyze_test_prompt,
                source_code=state["source_code"],
                transformed_code=state["transformed_code"],
                test_cases=current_test_code,
                test_result=test_result,
            )

            response = llm.invoke(messages)
            analysis = response.content.strip()

            next_step = "end"
            if state.get("retry_count", 0) < 3 and "Action" in analysis and "Revise" in analysis:
                next_step = "revise_test_cases"
                print("[DEBUG] Next step: revise_test_cases")

            return {"failure_analysis": analysis, "failure_responding": next_step}
        except Exception as e:
            print(f"[ERROR] Analysis failed: {e}")
            return {"failure_analysis": str(e), "failure_responding": "end"}

    def revise_test_cases(state: "State") -> "State":
        """실패 분석 기반 테스트 코드 수정"""
        try:
            print(f"[DEBUG] Revising test cases (retry: {state.get('retry_count', 0)})")

            messages = render_prompt_jinja2(
                revise_test_prompt,
                test_cases=state.get("generated_test_code", ""),
                failure_analysis=state.get("failure_analysis", ""),
            )

            response = llm.invoke(messages)
            code_block = extract_codeblock(response.content, langs=("java", ""))
            print(f"[DEBUG] Revised test code length: {len(code_block)}")

            return {
                "generated_test_code": code_block,
                "retry_count": state.get("retry_count", 0) + 1,
                "is_failure": False,
                "error_type": "",
            }
        except Exception as e:
            print(f"[ERROR] Revision failed: {e}")
            return {
                "retry_count": state.get("retry_count", 0) + 1,
                "failure_responding": "end"
            }

    # LangGraph 워크플로우 구성
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
    workflow.add_edge("revise_test_cases", "write_and_compile")  # 수정 후 다시 컴파일로

    graph = workflow.compile()

    logging.langsmith("VTW Project(JAVA)")

    run_root = os.path.join("./.tmp")
    if os.path.exists(run_root):
        shutil.rmtree(run_root)
    ensure_dir(run_root)

    initial_state: State = {
        "source_code": origin_target_code,
        "transformed_code": sem_target_code,
        "source_test_cases": test_code,
        "generated_test_code": "",
        "compile_stdout": "",
        "compile_stderr": "",
        "run_stdout": "",
        "run_stderr": "",
        "retry_count": 0,
        "is_failure": False,
        "error_type": "",
        "failure_analysis": "",
        "failure_responding": "end",
        "_run_root": run_root,
        "_idx": 0,
    }

    result: Dict[str, Any] = graph.invoke(initial_state)

    if result.get("compile_stderr"):
        print(f"[Compile Error]\n{result['compile_stderr'][:500]}")
    if result.get("run_stderr"):
        print(f"[Run Error]\n{result['run_stderr'][:500]}")
    if result.get("failure_analysis"):
        print(f"[Analysis]\n{result['failure_analysis'][:500]}")

    if result.get("retry_count", 0) == 3:
        print("Failed to generate test cases")

    print(result)
    subprocess.run(["rm", "-rf" "./.tmp"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    
    return result["generated_test_code"]

# 테스트 코드 (원본 유지)
if __name__=="__main__":
    
    origin_code = """def has_close_elements(numbers: List[float], threshold: float) -> bool:
    for idx, elem in enumerate(numbers):
        for idx2, elem2 in enumerate(numbers):
            if idx != idx2:
                distance = abs(elem - elem2)
                if distance < threshold:
                    return True

    return False
"""
    
    sem_equiv = sem_equiv_test(
        origin_code,
        "Qwen/Qwen2.5-Coder-32B-Instruct",
        "qwen2.5-coder:32b-instruct-q8_0",
        # 필요 시 OpenAI 호환으로:
        # generate_test_backend="openai",
        # openai_base_url="https://api.openai.com/v1",
        # openai_api_key=os.getenv("OPENAI_API_KEY", "EMPTY"),
    )
    
    print(sem_equiv[0])
    print(sem_equiv[1])
    
    origin_target_code = """import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_0 {

    static class HumanEval_0_Source {
        public static boolean hasCloseElements(List<Double> numbers, double threshold) {
            for (int idx = 0; idx < numbers.size(); idx++) {
                for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                    if (idx != idx2) {
                        double distance = Math.abs(numbers.get(idx) - numbers.get(idx2));
                        if (distance < threshold) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}"""
    
    sem_target_code = """import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_0 {
    static class HumanEval_0_Transformed {
        public boolean containsNearbyElements(List<Double> values, double limit) {
            int index = 0;
            while (index < values.size()) {
                int innerIndex = 0;
                while (innerIndex < values.size()) {
                    if (index != innerIndex) {
                        double gap = Math.abs(values.get(index) - values.get(innerIndex));
                        if (gap < limit) {
                            return true;
                        }
                    }
                    innerIndex++;
                }
                index++;
            }
            return false;
        }
    }
}"""
    
    test_code = """class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1.0, 2.0, 3.0], 0.5),
        ([1.0, 2.0, 3.0], 1.5),
        ([1.1, 2.2, 3.3], 0.1),
        ([1.1, 2.2, 3.3], 1.2),
        ([0.0, 0.0, 0.0], 0.0),
        ([0.0, 0.1, 0.2], 0.05),
        ([5.0, 4.9, 4.8], 0.2),
        ([10.0, 20.0, 30.0], 5.0),
        ([1.0, 1.0, 1.0, 1.0], 0.1),
        ([1.0, 2.0, 3.0, 4.0, 5.0], 1.1)
    ]

    expected_results = [
        False,
        True,
        False,
        True,
        True,
        False,
        True,
        False,
        True,
        True
    ]

    def test_0(self):
        self.assertEqual(has_close_elements(self.test_cases[0][0], self.test_cases[0][1]), contains_nearby_elements(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(has_close_elements(self.test_cases[1][0], self.test_cases[1][1]), contains_nearby_elements(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(has_close_elements(self.test_cases[2][0], self.test_cases[2][1]), contains_nearby_elements(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(has_close_elements(self.test_cases[3][0], self.test_cases[3][1]), contains_nearby_elements(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(has_close_elements(self.test_cases[4][0], self.test_cases[4][1]), contains_nearby_elements(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(has_close_elements(self.test_cases[5][0], self.test_cases[5][1]), contains_nearby_elements(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(has_close_elements(self.test_cases[6][0], self.test_cases[6][1]), contains_nearby_elements(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(has_close_elements(self.test_cases[7][0], self.test_cases[7][1]), contains_nearby_elements(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(has_close_elements(self.test_cases[8][0], self.test_cases[8][1]), contains_nearby_elements(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(has_close_elements(self.test_cases[9][0], self.test_cases[9][1]), contains_nearby_elements(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()
"""
    
    model_api = "qwen2.5-coder:32b-instruct-q8_0"
    temperature = 1.0
    
    result = generate_test_java(
        origin_target_code, sem_target_code, test_code, model_api, temperature,
        # 필요 시 OpenAI 호환으로:
        backend="openai",
        base_url="https://api.openai.com/v1",
        api_key=os.getenv("OPENAI_API_KEY", "EMPTY"),
    )
    
    print(result)
