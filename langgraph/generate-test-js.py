
import os
import re
import json
import random
import subprocess
from argparse import ArgumentParser
from typing import TypedDict

import numpy as np

import torch

from langchain_ollama import ChatOllama
from langgraph.graph import StateGraph, END
from langchain_core.prompts import ChatPromptTemplate
from langchain_teddynote import logging



def set_seed(seed):
    random.seed(seed)
    np.random.seed(seed)
    torch.manual_seed(seed)
    torch.cuda.manual_seed(seed)
    torch.cuda.manual_seed_all(seed)

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

def parse_args():
    
    parser = ArgumentParser()
    
    parser.add_argument("-sd", "--source_dir", type=str, default="/workspace/vtw/data/py2js")
    parser.add_argument("-td", "--transform_dir", type=str, default="/workspace/vtw/data/pyeq2js")
    parser.add_argument("-tcd", "--test_case_dir", type=str, default="/workspace/vtw/data/py_test")
    parser.add_argument("-od", "--output_dir", type=str, default="/workspace/vtw/data/js_test")
    
    parser.add_argument("--generate_test_prompt", type=str, default="/workspace/vtw/data/prompts/generate-js-test.txt")
    parser.add_argument("--analyze_test_prompt", type=str, default="/workspace/vtw/data/prompts/analyze-js-test.txt")
    parser.add_argument("--revise_test_prompt", type=str, default="/workspace/vtw/data/prompts/revise-js-test.txt")
    
    parser.add_argument("-m", "--model", type=str, default="qwen2.5-coder:32b-instruct-q8_0")
    
    parser.add_argument("--seed", type=int, default=42)
    
    return parser.parse_args()

def extract_test_cases(source_code):
    
    lines = source_code.split("\n")
    start_idx = 0
    
    for i, line in enumerate(lines):
        if line.strip().startswith("class"):
            start_idx = i - 1
            
    return "\n".join(lines[start_idx:])

def main(args):
    
    source_dir = args.source_dir
    if not source_dir.endswith("/"): source_dir += "/"
    sources = [open(source_dir + file, 'r').read() for file in sorted(os.listdir(source_dir), key=lambda x: int(x.split(".")[0]))]
    
    transform_dir = args.transform_dir
    if not transform_dir.endswith("/"): transform_dir += "/"
    transforms = [open(transform_dir + file, 'r').read() for file in sorted(os.listdir(transform_dir), key=lambda x: int(x.split(".")[0]))]
    
    test_case_dir = args.test_case_dir
    if not test_case_dir.endswith("/"): test_case_dir += "/"
    test_cases = [open(test_case_dir + file, 'r').read() for file in sorted(os.listdir(test_case_dir), key=lambda x: int(x.split(".")[0]))]
    
    output_dir = args.output_dir
    if not output_dir.endswith("/"): output_dir += "/"
    os.makedirs(output_dir, exist_ok=True)
    
    subprocess.run(
        f"cd {output_dir}; npm init -y", shell=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL
    )
    subprocess.run(
        f"cd {output_dir}; npm install --save-dev jest", shell=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL
    )
    
    llm = ChatOllama(model=args.model, base_url="http://localhost:11434")
    
    # node
    def generate_test_inputs(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(args.generate_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                source_code=state["source_code"],
                transformed_code=state["transformed_code"],
                test_cases=state["source_test_cases"]
            ),
        )
        
        code_blocks = re.findall(r"```(?:javascript)?\n(.*?)```", response.content, re.DOTALL)
        if len(code_blocks) == 0:
            code_blocks = [response]
        code_block = max(code_blocks, key=len).strip()
        
        with open(output_dir + "{}.test.js".format(args.current_idx), 'w') as f:
            f.write(code_block)
        
        return {"test_cases": code_block}
    
    # node
    def run_test_cases(state: State) -> State:
        
        try:
            result = subprocess.run(
                f"cd {args.output_dir}; npx jest {args.current_idx}.test.js",
                shell=True,
                text=True,
                capture_output=True,
                timeout = 5
            )
        except Exception as e:
            result = subprocess.CompletedProcess(args=["npx"], returncode=1, stdout="", stderr=str(e))
    
        if result.returncode == 0:
            return {"test_result": result.stdout, "is_failure": False}
        else:
            if state["retry_count"] == 3:
                return {"test_result": result.stderr, "is_failure": False, "retry_count": state["retry_count"] + 1}
            else:
                return {"test_result": result.stderr, "is_failure": True, "retry_count": state["retry_count"] + 1}
    
    # node
    def analyze_failure(state: State) -> State:
        prompt = ChatPromptTemplate.from_template(open(args.analyze_test_prompt, 'r').read())
        
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
        prompt = ChatPromptTemplate.from_template(open(args.revise_test_prompt, 'r').read())
        
        response = llm.invoke(
            prompt.format_messages(
                test_cases=state["test_cases"],
                failure_analysis=state["failure_analysis"]
            )
        )
        
        code_blocks = re.findall(r"```(?:javascript)?\n(.*?)```", response.content, re.DOTALL)
        code_block = max(code_blocks, key=len).strip()
        
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
    
    for i, (source, transform, test_case) in enumerate(zip(sources, transforms, test_cases)):
        
        print("---{}---".format(i))
        logging.langsmith("VTW Project(JavaScript)")
        
        args.current_idx = i
        
        initial_state = {
            "source_code": source,
            "transformed_code": transform,
            "source_test_cases": extract_test_cases(test_case),
            "test_cases": "",
            "retry_count": 0,
        }
        
        result = graph.invoke(initial_state)
        if result["retry_count"] == 4:
            print("Failed to generate test cases in {} iteration.".format(i))

        with open(output_dir + "report.txt", 'a') as f:
            result["index"] = i
            f.write(json.dumps(result, ensure_ascii=False) + "\n")

        print("-------")

if __name__=="__main__":
    
    args = parse_args()
    set_seed(args.seed)
    
    main(args)
