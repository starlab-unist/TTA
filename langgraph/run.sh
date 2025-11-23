
start_time=$(date +%s)

echo "RUNNING TO GENERATE THE SEMANTIC EQUIVALENT CODE AND PYTHON TEST CASES..."

rm -rf outputs
mkdir outputs

python main.py \
    --mode generate-source-test \
    --sources ./data/humaneval-python-10.jsonl \
    --source_equiv_outputs ./outputs/equiv \
    --source_test_outputs ./outputs/test-py \
    --llm_backend "openai" \
    --llm_base_url "http://localhost:8000/v1" \
    --llm_api Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "RUNNING TO GENERATE THE JAVASCRIPT TEST CASES..."

python main.py \
    --mode generate-target-test \
    --targets ./result/qwen/32b-py2js-10 \
    --equiv_targets ./result/qwen/32b-eq2js-10 \
    --source_test_cases ./outputs/test-py \
    --target_language javascript \
    --target_test_outputs ./outputs/test-js \
    --llm_backend "openai" \
    --llm_base_url "http://localhost:8000/v1" \
    --llm_api Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES..."

echo "VALIDATING THE GENERATED TEST CASES...0"
python validate.py \
    ./outputs/test-py/0.py \
    ./outputs/test-js/0.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...1"
python validate.py \
    ./outputs/test-py/1.py \
    ./outputs/test-js/1.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...2"
python validate.py \
    ./outputs/test-py/2.py \
    ./outputs/test-js/2.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...3"
python validate.py \
    ./outputs/test-py/3.py \
    ./outputs/test-js/3.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...4"
python validate.py \
    ./outputs/test-py/4.py \
    ./outputs/test-js/4.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...5"
python validate.py \
    ./outputs/test-py/5.py \
    ./outputs/test-js/5.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...6"
python validate.py \
    ./outputs/test-py/6.py \
    ./outputs/test-js/6.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...7"
python validate.py \
    ./outputs/test-py/7.py \
    ./outputs/test-js/7.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...8"
python validate.py \
    ./outputs/test-py/8.py \
    ./outputs/test-js/8.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

echo "VALIDATING THE GENERATED TEST CASES...9"
python validate.py \
    ./outputs/test-py/9.py \
    ./outputs/test-js/9.test.js \
    js \
    --backend openai \
    --base_url "http://localhost:8000/v1" \
    --model Qwen/Qwen3-Coder-30B-A3B-Instruct

end_time=$(date +%s)

elapsed_sec=$((end_time - start_time))
elapsed_min=$((elapsed_sec / 60))

echo "총 걸린 시간: ${elapsed_sec}초 (${elapsed_min}분)"
