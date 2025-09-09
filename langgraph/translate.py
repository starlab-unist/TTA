
import os
import json
import random
from tqdm import tqdm

from argparse import ArgumentParser

import numpy as np

import torch
from torch.nn.utils.rnn import pad_sequence

from transformers import (
    AutoModelForCausalLM,
    AutoTokenizer
)

def set_seed(seed):
    random.seed(seed)
    np.random.seed(seed)
    torch.manual_seed(seed)
    torch.cuda.manual_seed(seed)
    torch.cuda.manual_seed_all(seed)
    
def parse_args():

    parser = ArgumentParser()

    parser.add_argument("-i", "--input_dir", type=str, default="./data/semantic_equiv")
    parser.add_argument("-o", "--output_dir", type=str, default="./data/pyeq2js")
    parser.add_argument("-sp", "--system_prompt_dir", type=str, default="./data/prompts/translate-system.txt")
    parser.add_argument("-up", "--user_prompt_dir", type=str, default="./data/prompts/translate-user.txt")

    parser.add_argument("-m", "--model", type=str, default="Qwen/Qwen2.5-Coder-1B-Instruct")

    parser.add_argument("-b", "--batch_size", type=int, default=32)
    parser.add_argument("-ml", "--max_length", type=int, default=1024)
    
    parser.add_argument("--seed", type=int, default=42)

    return parser.parse_args()

def extract_code_block(source_code):
    
    lines = source_code.split("\n")
    start_idx = -1
    end_idx = -1
    
    for i, line in enumerate(lines):
        if start_idx != -1 and "```" in line:
            end_idx = i
        elif "```" in line:
            start_idx = i
            
    return "\n".join(lines[start_idx+1:end_idx])

def translate(args):

    output_dir = args.output_dir
    if not output_dir.endswith("/"): output_dir = output_dir + "/"

    os.makedirs(output_dir, exist_ok=True)

    if args.input_dir.endswith(".jsonl"):
        sources = [json.loads(line) for line in open(args.input_dir, 'r').readlines()]
        sources = [source["declaration"] + source["canonical_solution"] for source in sources]
    else:
        input_dir = args.input_dir
        if not input_dir.endswith("/"): input_dir = input_dir + "/"
        sources = [open(input_dir + file, 'r').read() for file in sorted(os.listdir(input_dir), key=lambda x: int(x.split(".")[0]))]

    system = open(args.system_prompt_dir, 'r').read()
    user = open(args.user_prompt_dir, 'r').read()

    tokenizer = AutoTokenizer.from_pretrained(args.model)

    model = AutoModelForCausalLM.from_pretrained(args.model, device_map="auto")
    model.eval()
    
    total = len(sources)
    n_iter = total // args.batch_size
    if total % args.batch_size != 0:
        n_iter += 1

    idx = 0
    for batch_idx in tqdm(range(n_iter)):
        
        start_idx = batch_idx * args.batch_size
        end_idx = (batch_idx + 1) * args.batch_size
        
        input_ids = []
        attention_mask = []
        
        for source in sources[start_idx:end_idx]:
            
            messages = [
                {"role": "system", "content": system},
                {"role": "user", "content": user.format(source_code=source)}
            ]
            
            inputs = tokenizer.apply_chat_template(messages, tokenize=False, add_generation_prompt=True)
            model_inputs = tokenizer([inputs], return_tensors="pt")
        
            input_ids.append(model_inputs.input_ids.squeeze())
            attention_mask.append(model_inputs.attention_mask.squeeze())
        
        input_ids = pad_sequence(input_ids, batch_first=True, padding_value=tokenizer.pad_token_id, padding_side="left")
        attention_mask = pad_sequence(attention_mask, batch_first=True, padding_value=0, padding_side="left")
        
        with torch.no_grad():
            output_ids = model.generate(
                input_ids=input_ids,
                attention_mask=attention_mask,
                max_new_tokens=args.max_length,
            )
            
        responses = tokenizer.batch_decode([
            output_id[len(input_id):] for input_id, output_id in zip(input_ids, output_ids)
        ], skip_special_tokens=True)
        
        for response in responses:
            with open(output_dir + "{}.js".format(idx), 'w') as f:
                f.write(extract_code_block(response))
                
            idx += 1

if __name__=="__main__":

    args = parse_args()
    set_seed(args.seed)
    
    translate(args)
