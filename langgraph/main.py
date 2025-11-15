#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# ============================================================
# Adds an OpenAI-compatible backend while preserving your
# original logic and Ollama usage. Only "compatible" pieces
# are added; existing behavior is unchanged unless you opt-in.
# Comments are in English as requested.
# ============================================================

import os
import re
import glob
import json
import shutil
import subprocess
from tqdm import tqdm
from types import SimpleNamespace
from typing import Dict, Any, List, Tuple, Optional, TypedDict

from argparse import ArgumentParser

# (Optional) Local HF inference was removed to avoid logic changes.
# If you want to use HF again, re-enable these:
# import torch
# from transformers import AutoTokenizer, AutoModelForCausalLM

from langchain_ollama import ChatOllama
from langgraph.graph import StateGraph, END
from langchain_core.prompts import ChatPromptTemplate
from langchain_teddynote import logging

from generate_equiv import extract_code_block
from generate_test_js import extract_test_cases

# =========================
# OpenAI-compatible adapter
# =========================
from openai import OpenAI
import httpx
from langchain_core.messages import BaseMessage, SystemMessage, HumanMessage


def _lc_messages_to_openai(messages: List[BaseMessage]) -> List[Dict[str, str]]:
    """Convert LangChain Message objects into OpenAI /v1 chat-completions schema."""
    out: List[Dict[str, str]] = []
    for m in messages:
        if isinstance(m, SystemMessage):
            out.append({"role": "system", "content": m.content})
        elif isinstance(m, HumanMessage):
            out.append({"role": "user", "content": m.content})
        else:
            # Treat other types as assistant
            out.append({"role": "assistant", "content": m.content})
    return out


class OpenAICompat:
    """
    Minimal adapter to call OpenAI (or OpenAI-compatible) /v1/chat/completions
    using the official OpenAI SDK. Provides `.invoke(messages)` returning an
    object with `.content` to match ChatOllama's pattern.
    """
    def __init__(
        self,
        model: str,
        base_url: str,
        api_key: str,
        timeout: int = 120,
        temperature: float = 0.0,
    ):
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


# ============================================================
# Python equivalence test generation
# ============================================================
def sem_equiv_test(
    origin_code: str = None,
    generate_test_model: str = None,
    temperature: float = 1.0,

    # ---- OpenAI-compatible options ----
    generate_test_backend: str = "ollama",          # "ollama"(default) or "openai"
    openai_base_url: str = "http://localhost:11434/v1",
    openai_api_key: str = "EMPTY",
    llm_timeout: int = 120,
):
    """
    1) Generate a semantically equivalent transformation of the input code (via OpenAICompat).
    2) Generate Python test cases to validate equivalence (Ollama by default; OpenAI-compatible if requested).
    Only "compatible" functionality is added; core behavior remains the same.
    """

    # Load prompts and examples
    system = open("./data/prompts/generate-equiv-system.txt", 'r', encoding="utf-8").read()
    user = open("./data/prompts/generate-equiv-user.txt", 'r', encoding="utf-8").read()
    examples = json.load(open("./data/prompts/examples.json", 'r', encoding="utf-8"))["Python"]

    # (1) Equivalent code generation using OpenAI-compatible backend
    if generate_test_backend == "openai":
        llm_equiv = OpenAICompat(
            model=generate_test_model,
            base_url=openai_base_url,
            api_key=openai_api_key,
            timeout=llm_timeout,
            temperature=temperature,
        )
    else:
        llm_equiv = ChatOllama(model=generate_test_model, base_url="http://localhost:11434")

    messages = [
        SystemMessage(content=system),
        HumanMessage(content=user.format(
            source_example=examples["Source"],
            target_example=examples["Target"],
            language="python",
            source=origin_code
        )),
    ]

    response = llm_equiv.invoke(messages)
    equiv_code = extract_code_block(response.content)

    # (2) Test-case generation backend (Ollama or OpenAI-compatible)
    if generate_test_backend == "openai":
        llm = OpenAICompat(
            model=generate_test_model,
            base_url=openai_base_url,
            api_key=openai_api_key,
            timeout=llm_timeout,
            temperature=temperature,
        )
    else:
        # Ollama default
        llm = ChatOllama(model=generate_test_model, base_url="http://localhost:11434")

    generate_test_prompt = "./data/prompts/generate-py-test.txt"
    analyze_test_prompt = "./data/prompts/analyze-py-test.txt"
    generate_equiv_prompt = "./data/prompts/generate-equiv-user.txt"
    revise_test_prompt = "./data/prompts/revise-py-test.txt"

    class PyState(TypedDict):
        source_code: str
        transformed_code: str
        test_cases: str
        retry_count: int
        test_result: str
        is_failure: bool
        failure_analysis: str
        failure_responding: str

    # Node: generate initial test cases
    def generate_test_inputs(state):
        prompt = ChatPromptTemplate.from_template(open(generate_test_prompt, 'r', encoding="utf-8").read())
        response = llm.invoke(
            prompt.format_messages(
                source_code=state["source_code"],
                transformed_code=state["transformed_code"]
            ),
        )
        code_blocks = re.findall(r"```(?:python)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        return {"test_cases": code_block}

    # Node: run tests locally with Python
    def run_test_cases(state):
        try:
            with open(".tmp.py", 'w', encoding="utf-8") as f:
                f.write(state["test_cases"])
            result = subprocess.run(
                ["python", ".tmp.py"],
                text=True,
                capture_output=True,
                timeout=5
            )
        except Exception as e:
            result = subprocess.CompletedProcess(args=["python"], returncode=1, stdout="", stderr=str(e))

        subprocess.run(["rm", ".tmp.py"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

        if result.returncode == 0 or state["retry_count"] == 3:
            return {"test_result": result.stdout, "is_failure": False}
        else:
            return {"test_result": result.stderr, "is_failure": True, "retry_count": state["retry_count"] + 1}

    # Node: analyze failure with LLM
    def analyze_failure(state):
        prompt = ChatPromptTemplate.from_template(open(analyze_test_prompt, 'r', encoding="utf-8").read())
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
                if "transformed code" in line:
                    failure_responding = "revise_transformed_code"
                elif "test cases" in line:
                    failure_responding = "revise_test_cases"
        return {"failure_analysis": response.content.strip(), "failure_responding": failure_responding}

    # Node: revise transformed code (if LLM suggests)
    def revise_transformed_code(state):
        prompt = ChatPromptTemplate.from_template(open(generate_equiv_prompt, 'r', encoding="utf-8").read())
        response = llm.invoke(
            prompt.format_messages(
                source=state["source_code"]
            )
        )
        code_blocks = re.findall(r"```(?:python)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        return {"transformed_code": code_block}

    # Node: revise test cases (if LLM suggests)
    def revise_test_cases(state):
        prompt = ChatPromptTemplate.from_template(open(revise_test_prompt, 'r', encoding="utf-8").read())
        response = llm.invoke(
            prompt.format_messages(
                test_cases=state["test_cases"],
                failure_analysis=state["failure_analysis"]
            )
        )
        code_blocks = re.findall(r"```(?:python)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        return {"test_cases": code_block}

    # Routing functions (named; avoids lambda .name issue)
    def route_after_run_py(state):
        return "analyze_failure" if state["is_failure"] else END

    def route_after_analyze_py(state):
        return state["failure_responding"]

    # Build the workflow
    workflow = StateGraph(PyState)

    workflow.add_node("generate_test_inputs", generate_test_inputs)
    workflow.add_node("run_test_cases", run_test_cases)
    workflow.add_node("analyze_failure", analyze_failure)
    workflow.add_node("revise_transformed_code", revise_transformed_code)
    workflow.add_node("revise_test_cases", revise_test_cases)

    workflow.set_entry_point("generate_test_inputs")
    workflow.add_edge("generate_test_inputs", "run_test_cases")

    workflow.add_conditional_edges(
        "run_test_cases",
        route_after_run_py,
        {"analyze_failure": "analyze_failure", END: END}
    )

    workflow.add_conditional_edges(
        "analyze_failure",
        route_after_analyze_py,
        {
            "revise_transformed_code": "revise_transformed_code",
            "revise_test_cases": "revise_test_cases",
            END: END
        }
    )

    workflow.add_edge("revise_transformed_code", "generate_test_inputs")
    workflow.add_edge("revise_test_cases", "run_test_cases")

    graph = workflow.compile()

    initial_state: PyState = {
        "source_code": origin_code,
        "transformed_code": equiv_code,
        "test_cases": "",
        "retry_count": 0,
        "test_result": "",
        "is_failure": False,
        "failure_analysis": "",
        "failure_responding": END,
    }

    result = graph.invoke(initial_state)
    if result.get("retry_count", 0) == 3:
        print("Failed to generate test cases.")

    print(result)

    return (equiv_code, result["test_cases"])


# ============================================================
# JS (Jest) test generation
# ============================================================
def generate_test_js(
    origin_target_code: str = None,
    sem_target_code: str = None,
    test_code: str = None,
    model_api: str = None,
    temperature: float = 1.0,

    # ---- OpenAI-compatible options ----
    backend: str = "ollama",                    # "ollama"(default) or "openai"
    base_url: str = "http://localhost:11434/v1",
    api_key: str = "EMPTY",
    llm_timeout: int = 120,
):
    """
    Generate JavaScript (Jest) tests to validate semantic equivalence.
    Behavior unchanged; you can switch LLM backend via `backend`.
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
        # Ollama default
        llm = ChatOllama(model=model_api, base_url="http://localhost:11434")

    generate_test_prompt = "./data/prompts/generate-js-test.txt"
    analyze_test_prompt = "./data/prompts/analyze-js-test.txt"
    revise_test_prompt = "./data/prompts/revise-js-test.txt"

    os.makedirs("./.tmp", exist_ok=True)
    subprocess.run("cd ./.tmp; npm init -y", shell=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    subprocess.run("cd ./.tmp; npm install --save-dev jest", shell=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

    class JSState(TypedDict):
        source_code: str
        transformed_code: str
        source_test_cases: str
        test_cases: str
        retry_count: int
        test_result: str
        is_failure: bool
        failure_analysis: str
        failure_responding: str

    # Node: generate initial tests
    def generate_test_inputs(state):
        prompt = ChatPromptTemplate.from_template(open(generate_test_prompt, 'r', encoding="utf-8").read())
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

    # Node: run tests using Jest
    def run_test_cases(state):
        try:
            with open("./.tmp/code.test.js", 'w', encoding="utf-8") as f:
                f.write(state["test_cases"])
            result = subprocess.run(
                "cd ./.tmp; npx jest code.test.js",
                shell=True,
                text=True,
                capture_output=True,
                timeout=5
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

    # Node: analyze failures
    def analyze_failure(state):
        prompt = ChatPromptTemplate.from_template(open(analyze_test_prompt, 'r', encoding="utf-8").read())
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
                if "Revise" in line:
                    failure_responding = "revise_test_cases"
        return {"failure_analysis": response.content.strip(), "failure_responding": failure_responding}

    # Node: revise tests
    def revise_test_cases(state):
        prompt = ChatPromptTemplate.from_template(open(revise_test_prompt, 'r', encoding="utf-8").read())
        response = llm.invoke(
            prompt.format_messages(
                test_cases=state["test_cases"],
                failure_analysis=state["failure_analysis"]
            )
        )
        code_blocks = re.findall(r"```(?:javascript)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip() if code_blocks else response.content.strip()
        return {"test_cases": code_block}

    # Routing (named)
    def route_after_run_js(state):
        return "analyze_failure" if state["is_failure"] else END

    def route_after_analyze_js(state):
        return state["failure_responding"]

    # Build workflow
    workflow = StateGraph(JSState)
    workflow.add_node("generate_test_inputs", generate_test_inputs)
    workflow.add_node("run_test_cases", run_test_cases)
    workflow.add_node("analyze_failure", analyze_failure)
    workflow.add_node("revise_test_cases", revise_test_cases)
    workflow.set_entry_point("generate_test_inputs")
    workflow.add_edge("generate_test_inputs", "run_test_cases")
    workflow.add_conditional_edges("run_test_cases", route_after_run_js,
                                   {"analyze_failure": "analyze_failure", END: END})
    workflow.add_conditional_edges("analyze_failure", route_after_analyze_js,
                                   {"revise_test_cases": "revise_test_cases", END: END})
    workflow.add_edge("revise_test_cases", "run_test_cases")

    graph = workflow.compile()

    initial_state: JSState = {
        "source_code": origin_target_code,
        "transformed_code": sem_target_code,
        "source_test_cases": extract_test_cases(test_code),
        "test_cases": "",
        "retry_count": 0,
        "test_result": "",
        "is_failure": False,
        "failure_analysis": "",
        "failure_responding": END,
    }

    result = graph.invoke(initial_state)
    if result.get("retry_count", 0) == 4:
        print("Failed to generate test cases")

    print(result)
    subprocess.run(["rm", "-rf" "./.tmp"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    return result["test_cases"]


# ============================================================
# Java (JUnit) test generation
# ============================================================
def generate_test_java(
    origin_target_code: str = None,
    sem_target_code: str = None,
    test_code: str = None,
    model_api: str = None,
    temperature: float = 1.0,

    # ---- OpenAI-compatible options ----
    backend: str = "ollama",                    # "ollama"(default) or "openai"
    base_url: str = "http://localhost:11434/v1",
    api_key: str = "EMPTY",
    llm_timeout: int = 120,

    output_folder: str = "./.tmp"
):
    """
    Generate Java (JUnit) tests to validate semantic equivalence.
    Behavior unchanged; you can switch LLM backend via `backend`.
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
        # Ollama default
        llm = ChatOllama(model=model_api, base_url="http://localhost:11434")

    generate_test_prompt = "./data/prompts/generate-java-test.txt"
    analyze_test_prompt = "./data/prompts/analyze-java-test.txt"
    revise_test_prompt = "./data/prompts/revise-java-test.txt"
    junit_jar = "./data/junit.jar"

    class JavaState(TypedDict):
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

    # ---- Basic file/OS helpers ----
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
        """Normalize test class name and ensure minimal imports."""
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

    # ---- Workflow nodes (no type hints to avoid get_type_hints issues) ----
    def generate_test_inputs(state):
        """Initial JUnit test generation with LLM."""
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

    def write_and_compile(state):
        """Write CUT and tests, then compile."""
        run_root = state["_run_root"]
        idx = state["_idx"]
        classes_dir = os.path.join(run_root, "classes")
        ensure_dir(classes_dir)

        # Write CUT (Code Under Test)
        cut_code = state["transformed_code"]
        cut_pkg = extract_package(cut_code)
        cut_public = extract_public_class_name(cut_code) or "CutClass"
        cut_dir = package_to_dir(classes_dir, cut_pkg)
        cut_path = os.path.join(cut_dir, f"{cut_public}.java")
        write_file(cut_path, cut_code)

        # Write Test file
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

        # Compile everything under classes_dir
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

    def run_tests(state):
        """Run tests via JUnit platform console (standalone jar)."""
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

    def analyze_failure(state):
        """LLM-based failure analysis and next action decision."""
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

    def revise_test_cases(state):
        """Revise tests based on failure analysis and retry."""
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

    # Routing (named)
    def route_after_run(state):
        return "analyze_failure" if state.get("is_failure") else "end"

    def route_after_analyze(state):
        if state.get("retry_count", 0) >= 3:
            return "end"
        return "revise_test_cases" if state.get("failure_responding") == "revise_test_cases" else "end"

    # Build workflow
    workflow = StateGraph(JavaState)
    workflow.add_node("generate_test_inputs", generate_test_inputs)
    workflow.add_node("write_and_compile", write_and_compile)
    workflow.add_node("run_tests", run_tests)
    workflow.add_node("analyze_failure", analyze_failure)
    workflow.add_node("revise_test_cases", revise_test_cases)

    workflow.set_entry_point("generate_test_inputs")
    workflow.add_edge("generate_test_inputs", "write_and_compile")
    workflow.add_edge("write_and_compile", "run_tests")
    workflow.add_conditional_edges("run_tests", route_after_run,
                                   {"analyze_failure": "analyze_failure", "end": END})
    workflow.add_conditional_edges("analyze_failure", route_after_analyze,
                                   {"revise_test_cases": "revise_test_cases", "end": END})
    workflow.add_edge("revise_test_cases", "write_and_compile")

    graph = workflow.compile()

    logging.langsmith("VTW Project(JAVA)")

    # run_root = os.path.join("./.tmp")
    run_root = os.path.join(output_folder)
    if os.path.exists(run_root):
        shutil.rmtree(run_root)
    ensure_dir(run_root)

    initial_state: JavaState = {
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
        "_idx": int(run_root.split("/")[-1]),
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
    # subprocess.run(["rm", "-rf" "./.tmp"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    return result["generated_test_code"]


# ============================================================
# Example usage (you can comment out this block)
# ============================================================
if __name__ == "__main__":

    parser = ArgumentParser()

    parser.add_argument("-m", "--mode", type=str, choices=["generate-source-test", "generate-target-test"], default="generate-source-test")

    # for generate-source-test
    parser.add_argument("-s", "--sources", type=str, default="./data/humaneval-python.jsonl")

    parser.add_argument("-seo", "--source_equiv_outputs", type=str, default="")
    parser.add_argument("-sto", "--source_test_outputs", type=str, default="")

    # for generate-target-test
    parser.add_argument("-t", "--targets", type=str, default="./result/32b-py2js")
    parser.add_argument("-et", "--equiv_targets", type=str, default="./result/32b-eq2js")
    parser.add_argument("-stc", "--source_test_cases", type=str, default="./data/test-py")
    parser.add_argument("-l", "--target_language", type=str, choices=["javascript", "java"], default="javascript")

    parser.add_argument("-tto", "--target_test_outputs", type=str, default="")

    # llm setting
    parser.add_argument("--llm_backend", type=str, choices=["openai", "ollama"], default="ollama")
    parser.add_argument("--llm_api", type=str, default="qwen3:8b-q8_0")

    args = parser.parse_args()

    extention = {
        "python": "py",
        "javascript": "js",
        "java": "java"
    }

    def extract_file_number(path):
        filename = path.split("/")[-1]
        if filename.endswith(".java"):
            return int(filename.split(".")[0].split("_")[-1])
        else:
            return int(filename.split(".")[0])

    def get_files(input_source, language):

        if os.path.isdir(input_source):
            # 폴더
            input_dir = input_source
            if input_dir.endswith("/"):
                input_dir = input_dir[:-1]
            
            ext = extention[language.lower()]

            files = sorted(glob.glob(f"{input_dir}/*.{ext}"), key=extract_file_number)
            sources = [open(file, 'r').read() for file in files]

        elif input_source.endswith(".jsonl"):
            # JSONL 파일
            lines = open(input_source, 'r').readlines()
            sources = [json.loads(line) for line in lines]

            sources = [source["declaration"] + source["canonical_solution"] for source in sources]
        
        else:
            # 단일 파일
            sources = [open(input_source, 'r').read()]
        
        return sources

    if args.mode == "generate-source-test":

        sources = get_files(args.sources, language="python")

        assert args.source_equiv_outputs != "", "Set the folder in which to output semantically equivalent files (-seo, --source_equiv_outputs)."
        os.makedirs(args.source_equiv_outputs, exist_ok=True)

        if args.source_equiv_outputs.endswith("/"): equiv_outputs = args.source_equiv_outputs[:-1]
        else: equiv_outputs = args.source_equiv_outputs

        assert args.source_test_outputs != "", "Set the folder in which to output test cases (-sto, --source_test_outputs)"
        os.makedirs(args.source_test_outputs, exist_ok=True)

        if args.source_test_outputs.endswith("/"): test_outputs = args.source_test_outputs[:-1]
        else: test_outputs = args.source_test_outputs

        for idx, source in enumerate(tqdm(sources)):
            
            equiv, test_case = sem_equiv_test(
                source,
                generate_test_model=args.llm_api,
                generate_test_backend=args.llm_backend,
                openai_base_url="https://api.openai.com/v1",
                openai_api_key=os.getenv("OPENAI_API_KEY", "EMPTY")
            )

            with open(f"{equiv_outputs}/{idx}.py", 'w') as f:
                f.write(equiv)
            
            with open(f"{test_outputs}/{idx}.py", 'w') as f:
                f.write(test_case)

    elif args.mode == "generate-target-test":

        targets = get_files(args.targets, language=args.target_language)
        equiv_targets = get_files(args.equiv_targets, language=args.target_language)
        test_cases = get_files(args.source_test_cases, language="python")

        assert len(targets) == len(equiv_targets) == len(test_cases), "The number of translations and semantically equivalent of translations and test cases is different!"

        assert args.target_test_outputs != "", "Set the folder in which to output test cases (-tto, --target_test_outputs)"
        os.makedirs(args.target_test_outputs, exist_ok=True)

        if args.target_test_outputs.endswith("/"): test_outputs = args.target_test_outputs[:-1]
        else: test_outputs = args.target_test_outputs

        base_url = "https://localhost:11434/v1" if args.llm_backend == "ollama" else "https://api.openapi.com/v1"

        for idx, (target, equiv_target, test_case) in enumerate(tqdm(zip(targets, equiv_targets, test_cases))):

            if args.target_language == "javascript":

                result = generate_test_js(
                    target, equiv_target, test_case,
                    model_api=args.llm_api,
                    backend=args.llm_backend,
                    base_url=base_url,
                    api_key=os.getenv("OPENAI_API_KEY", "EMPTY"),
                )

                with open(f"{test_outputs}/{idx}.test.js", 'w') as f:
                    f.write(result)
            
            elif args.target_language == "java":

                result = generate_test_java(
                    target, equiv_target, test_case,
                    model_api=args.llm_api,
                    backend=args.llm_backend,
                    base_url=base_url,
                    api_key=os.getenv("OPENAI_API_KEY", "EMPTY"),
                    output_folder = f"{test_outputs}/{idx}"
                )

    print("Done!")

#     origin_code = """def has_close_elements(numbers: List[float], threshold: float) -> bool:
#     for idx, elem in enumerate(numbers):
#         for idx2, elem2 in enumerate(numbers):
#             if idx != idx2:
#                 distance = abs(elem - elem2)
#                 if distance < threshold:
#                     return True
#     return False
# """

#     # Generate equivalent code (via OpenAI-compatible adapter) and Python tests
#     sem_equiv = sem_equiv_test(
#         origin_code,
#         generate_test_model="qwen3:8b-q8_0",
#         # To use OpenAI-compatible for test generation too:
#         # generate_test_backend="openai",
#         # openai_base_url="https://api.openai.com/v1",
#         # openai_api_key=os.getenv("OPENAI_API_KEY", "EMPTY"),
#     )
#     print(sem_equiv[0])  # equivalent code
#     print(sem_equiv[1])  # generated python tests

#     origin_target_code = """import java.util.List;
# import org.junit.jupiter.api.Test;
# import static org.junit.jupiter.api.Assertions.assertEquals;

# public class HumanEval_0 {
#     static class HumanEval_0_Source {
#         public static boolean hasCloseElements(List<Double> numbers, double threshold) {
#             for (int idx = 0; idx < numbers.size(); idx++) {
#                 for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
#                     if (idx != idx2) {
#                         double distance = Math.abs(numbers.get(idx) - numbers.get(idx2));
#                         if (distance < threshold) {
#                             return true;
#                         }
#                     }
#                 }
#             }
#             return false;
#         }
#     }
# }"""

#     sem_target_code = """import java.util.List;
# import org.junit.jupiter.api.Test;
# import static org.junit.jupiter.api.Assertions.assertEquals;

# public class HumanEval_0 {
#     static class HumanEval_0_Transformed {
#         public boolean containsNearbyElements(List<Double> values, double limit) {
#             int index = 0;
#             while (index < values.size()) {
#                 int innerIndex = 0;
#                 while (innerIndex < values.size()) {
#                     if (index != innerIndex) {
#                         double gap = Math.abs(values.get(index) - values.get(innerIndex));
#                         if (gap < limit) {
#                             return true;
#                         }
#                     }
#                     innerIndex++;
#                 }
#                 index++;
#             }
#             return false;
#         }
#     }
# }"""

#     test_code = """class TestFunctionEquivalence(unittest.TestCase):
#     test_cases = [
#         ([1.0, 2.0, 3.0], 0.5),
#         ([1.0, 2.0, 3.0], 1.5),
#         ([1.1, 2.2, 3.3], 0.1),
#         ([1.1, 2.2, 3.3], 1.2),
#         ([0.0, 0.0, 0.0], 0.0),
#         ([0.0, 0.1, 0.2], 0.05),
#         ([5.0, 4.9, 4.8], 0.2),
#         ([10.0, 20.0, 30.0], 5.0),
#         ([1.0, 1.0, 1.0, 1.0], 0.1),
#         ([1.0, 2.0, 3.0, 4.0, 5.0], 1.1)
#     ]
#     expected_results = [False, True, False, True, True, False, True, False, True, True]
#     def test_0(self): ...
# """

#     model_api = "qwen3:8b-q8_0"
#     result = generate_test_java(
#         origin_target_code, sem_target_code, test_code, model_api, 1.0,
#         # To use OpenAI-compatible API for the Java test LLM:
#         # backend="openai",
#         # base_url="https://api.openai.com/v1",
#         # api_key=os.getenv("OPENAI_API_KEY", "EMPTY"),
#     )
#     print(result)
