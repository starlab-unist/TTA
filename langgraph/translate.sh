
python translate-java.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/3b-py2java \
    -m Qwen/Qwen2.5-Coder-3B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python translate-java.py \
    -i ./data/equiv \
    -o ./result/qwen/3b-eq2java \
    -m Qwen/Qwen2.5-Coder-3B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python translate-java.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/7b-py2java \
    -m Qwen/Qwen2.5-Coder-7B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python translate-java.py \
    -i ./data/equiv \
    -o ./result/qwen/7b-eq2java \
    -m Qwen/Qwen2.5-Coder-7B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python translate-java.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/17b-py2java \
    -m Qwen/Qwen2.5-Coder-17B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python translate-java.py \
    -i ./data/equiv \
    -o ./result/qwen/17b-eq2java \
    -m Qwen/Qwen2.5-Coder-17B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python translate-java.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/32b-py2java \
    -m Qwen/Qwen2.5-Coder-32B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python translate-java.py \
    -i ./data/equiv \
    -o ./result/qwen/32b-eq2java \
    -m Qwen/Qwen2.5-Coder-32B-Instruct \
    -up ./data/prompts/translate-user-java.txt

python generate-test-java.py \
    -sd ./result/qwen/32b-py2java \
    -td ./result/qwen/32b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/32b-test-js
    
python generate-test-java.py \
    -sd ./result/qwen/14b-py2java \
    -td ./result/qwen/14b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/14b-test-js
    
python generate-test-java.py \
    -sd ./result/qwen/7b-py2java \
    -td ./result/qwen/7b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/7b-test-js
    
python generate-test-java.py \
    -sd ./result/qwen/3b-py2java \
    -td ./result/qwen/3b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/3b-test-js
    