# install testpilot

cd /root
git clone https://github.com/neu-se/testpilot2.git

cd /root/testpilot2
npm run build

# run experiment

export TESTPILOT_LLM_API_ENDPOINT="http://localhost:11434/v1/chat/completions"
export TESTPILOT_LLM_AUTH_HEADERS='{"Authorization": "" }'


cp -r /root/projects /root/testpilot2/projects

mkdir /root/testpilot2/results/bluebird
mkdir /root/testpilot2/results/q
mkdir /root/testpilot2/results/complex.js
mkdir /root/testpilot2/results/memfs
mkdir /root/testpilot2/results/pull-stream

node /root/testpilot2/benchmark/run.js --outputDir /root/testpilot2/results/bluebird --package  /root/testpilot2/projects/bluebird --model qwen2.5:72b --timeLimit 7200 --temperatures 0.7
node /root/testpilot2/benchmark/run.js --outputDir /root/testpilot2/results/q --package  /root/testpilot2/projects/q --model qwen2.5:72b --timeLimit 7200 --temperatures 0.7
node /root/testpilot2/benchmark/run.js --outputDir /root/testpilot2/results/pull-stream --package  /root/testpilot2/projects/pull-stream --model qwen2.5:72b --timeLimit 7200 --temperatures 0.7
node /root/testpilot2/benchmark/run.js --outputDir /root/testpilot2/results/complex.js --package  /root/testpilot2/projects/Complex.js --model qwen2.5:72b --timeLimit 7200 --temperatures 0.7
node /root/testpilot2/benchmark/run.js --outputDir /root/testpilot2/results/memfs --package  /root/testpilot2/projects/memfs --model qwen2.5:72b --timeLimit 7200 --temperatures 0.7

# get coverage

cd /root
mkdir /root/eval/testpilot

apt-install jq

jq '.coverage.total' /root/testpilot2/results/bluebird/report.json > /root/eval/testpilot/coverage_bluebird.log
jq '.coverage.total' /root/testpilot2/results/q/report.json > /root/eval/testpilot/coverage_q.log
jq '.coverage.total' /root/testpilot2/results/complex.js/report.json > /root/eval/testpilot/coverage_complex.js.log
jq '.coverage.total' /root/testpilot2/results/pull-stream/report.json > /root/eval/testpilot/coverage_pull-stream.log
jq '.coverage.total' /root/testpilot2/results/memfs/report.json > /root/eval/testpilot/coverage_memfs.log

