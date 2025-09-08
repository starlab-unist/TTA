
import os
import re
import json
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

def sem_equiv_test(
    origin_code: str = None,
    generate_equiv_model: str = None,
    generate_test_model: str = None,
    temperature: float = 1.0,
):
    """
    1. 입력된 소스 코드의 동등 변형 생성
    2. 원본 소스 코드와 동등 변형 코드 간의 동등성을 검증하는 테스트 케이스 생성
    자세한 내용은 같은 디렉토리에 첨부한 '동등 변형 기반 변환기 검증 실험 매뉴얼.pdf' 참조
    
    Arguments:
        origin_code {str} -- 원본 소스 코드
        generate_equiv_model {str} -- 동등 변형을 생성하는 LLM의 모델 API, Huggingface 사용
        generate_test_model {str} -- 테스트 케이스를 생성하는 LLM 모델 API, Ollama 사용
        temperature {float} -- LLM의 토큰 생성 시 top-p sampling의 정도를 조절하는 하이퍼파라미터. 높을수록 창의적인 답변, 낮을수록 정확한 답변이 생성됨 (default: 1.0).
    
    Returns:
        Tuple(str, str) -- 생성된 동등 변형 코드, 테스트 케이스 코드
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
    
    # 테스트 케이스 생성
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
        code_block = max(code_blocks, key=len).strip()
        
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
            return {"test_result": result.stderr, "is_failure": True, "retry_count": state["retry_count"] + 1, }
    
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
        code_block = max(code_blocks, key=len).strip()
        
        return {"transformed_code": code_block, }
    
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
        code_block = max(code_blocks, key=len).strip()
        
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
    if result["retry_count"] == 3:
        print("Failed to generate test cases.")
    
    print(result)
    
    return (equiv_code, result["test_cases"])

def generate_test(
    origin_target_code: str = None,
    sem_target_code: str = None,
    test_code: str = None,
    model_api: str = None,
    temperature: float = 1.0,
):
    """
    번역된 소스 코드와 동등 변형 코드 간의 동등성을 검증하는 테스트 케이스 생성 코드.
    중심 언어로 작성된 테스트 케이스를 통해 동일한 내용의 테스트 케이스를 생성하도록 구현됨.
    자세한 내용은 같은 디렉토리에 첨부한 '동등 변형 기반 변환기 검증 실험 매뉴얼.pdf' 참조
    
    Arguments:
        origin_target_code {str} -- 번역된 원본 소스 코드
        sem_target_code {str} -- 번역된 동등 변형 코드
        test_code {str} -- 중심 언어로 작성된 테스트 케이스 코드
        model_api -- 테스트 케이스를 생성하는 LLM 모델 API, Ollama 사용
        temperature {float} -- LLM의 토큰 생성 시 top-p sampling의 정도를 조절하는 하이퍼파라미터. 높을수록 창의적인 답변, 낮을수록 정확한 답변이 생성됨 (default: 1.0).
    
    Returns:
        str -- 목표 언어로 작성된 테스트 케이스 코드
    """
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
            code_blocks = [response]
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
    
    initial_state = {
        "source_code": origin_target_code,
        "transformed_code": sem_target_code,
        "source_test_cases": extract_test_cases(test_code),
        "test_cases": "",
        "retry_count": 0,
    }
    
    result = graph.invoke(initial_state)
    if result["retry_count"] == 4:
        print("Failed to generate test cases")

    print(result)
    subprocess.run(["rm", "-rf" "./.tmp"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    
    return result["test_cases"]

# 테스트 코드
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
        "qwen2.5-coder:32b-instruct-q8_0"
    )
    
    print(sem_equiv[0])
    print(sem_equiv[1])
    
    origin_target_code = """function hasCloseElements(numbers, threshold) {
    for (let idx = 0; idx < numbers.length; idx++) {
        for (let idx2 = 0; idx2 < numbers.length; idx2++) {
            if (idx !== idx2) {
                const distance = Math.abs(numbers[idx] - numbers[idx2]);
                if (distance < threshold) {
                    return true;
                }
            }
        }
    }

    return false;
}
"""
    
    sem_target_code = """function containsNearbyElements(values, limit) {
    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                const gap = Math.abs(values[index] - values[innerIndex]);
                if (gap < limit) {
                    return true;
                }
            }
            innerIndex += 1;
        }
        index += 1;
    }

    return false;
}"""
    
    test_code = sem_equiv[0]
    
    model_api = "qwen2.5-coder:32b-instruct-q8_0"
    temperature = 1.0
    
    result = generate_test(
        origin_target_code, sem_target_code, test_code, model_api, temperature
    )

    print(result)
    