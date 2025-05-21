echo "RUNNING TO GENERATE THE SEMANTIC EQUIVALENT CODE..."
python generate-equiv.py \
    -s ./data/equiv

echo "RUNNING TO GENERATE THE PYTHON TEST CASES..."
python generate-test.py \
    -td ./data/equiv \
    -od ./data/test-py

echo "TRANSLATING THE SOURCE PYTHON CODE WITH QWEN-32B MODEL..."
python translate.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/32b-py2js \
    -m Qwen/Qwen2.5-Coder-32B-Instruct

echo "TRANSLATING THE SEMANTIC EQUIVALENT CODE WITH QWEN-32B MODEL..."
python translate.py \
    -i ./data/equiv \
    -o ./result/qwen/32b-eq2js \
    -m Qwen/Qwen2.5-Coder-32B-Instruct

echo "ANALYZING THE TRANSLATED CODES BY QWEN-32B MODEL..."
python generate-test-js.py \
    -sd ./result/qwen/32b-py2js \
    -td ./result/qwen/32b-eq2js \
    -tcd ./data/test-py \
    -od ./result/qwen/32b-test-js

echo "TRANSLATING THE SOURCE PYTHON CODE WITH QWEN-14B MODEL..."
python translate.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/14b-py2js \
    -m Qwen/Qwen2.5-Coder-14B-Instruct

echo "TRANSLATING THE SEMANTIC EQUIVALENT CODE WITH QWEN-14B MODEL..."
python translate.py \
    -i ./data/equiv \
    -o ./result/qwen/14b-eq2js \
    -m Qwen/Qwen2.5-Coder-14B-Instruct

echo "ANALYZING THE TRANSLATED CODES BY QWEN-14B MODEL..."
python generate-test-js.py \
    -sd ./result/qwen/14b-py2js \
    -td ./result/qwen/14b-eq2js \
    -tcd ./data/test-py \
    -od ./result/qwen/14b-test-js

echo "TRANSLATING THE SOURCE PYTHON CODE WITH QWEN-7B MODEL..."
python translate.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/7b-py2js \
    -m Qwen/Qwen2.5-Coder-7B-Instruct

echo "TRANSLATING THE SEMANTIC EQUIVALENT CODE WITH QWEN-7B MODEL..."
python translate.py \
    -i ./data/equiv \
    -o ./result/qwen/7b-eq2js \
    -m Qwen/Qwen2.5-Coder-7B-Instruct

echo "ANALYZING THE TRANSLATED CODES BY QWEN-7B MODEL..."
python generate-test-js.py \
    -sd ./result/qwen/7b-py2js \
    -td ./result/qwen/7b-eq2js \
    -tcd ./data/test-py \
    -od ./result/qwen/7b-test-js

echo "TRANSLATING THE SOURCE PYTHON CODE WITH QWEN-3B MODEL..."
python translate.py \
    -i ./data/humaneval-python.jsonl \
    -o ./result/qwen/3b-py2js \
    -m Qwen/Qwen2.5-Coder-3B-Instruct

echo "TRANSLATING THE SEMANTIC EQUIVALENT CODE WITH QWEN-3B MODEL..."
python translate.py \
    -i ./data/equiv \
    -o ./result/qwen/3b-eq2js \
    -m Qwen/Qwen2.5-Coder-3B-Instruct

echo "ANALYZING THE TRANSLATED CODES BY QWEN-3B MODEL..."
python generate-test-js.py \
    -sd ./result/qwen/3b-py2js \
    -td ./result/qwen/3b-eq2js \
    -tcd ./data/test-py \
    -od ./result/qwen/3b-test-js
