
python generate-test-java.py \
    -sd ./result/qwen/32b-py2java \
    -td ./result/qwen/32b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/32b-test-java2
    
python generate-test-java.py \
    -sd ./result/qwen/14b-py2java \
    -td ./result/qwen/14b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/14b-test-java
    
python generate-test-java.py \
    -sd ./result/qwen/7b-py2java \
    -td ./result/qwen/7b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/7b-test-java
    
python generate-test-java.py \
    -sd ./result/qwen/3b-py2java \
    -td ./result/qwen/3b-eq2java \
    -tcd ./data/test-py \
    -od ./result/qwen/3b-test-java
    