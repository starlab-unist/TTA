# env setup

source test-env/bin/activate
nvm use 16

# extract APIs for each project

cd /root
mkdir api

node exploreAPI.js /root/projects/bluebird /root/api/bluebird_api.json
node exploreAPI.js /root/projects/q /root/api/q_api.json
node exploreAPI.js /root/projects/pull-stream /root/api/pull-stream_api.json
node exploreAPI.js /root/projects/Complex.js /root/api/complex.js.json
node exploreAPI.js /root/projects/memfs /root/api/memfs_api.json


# run experiment

cd /root

mkdir /root/gen_test/bluebird
mkdir /root/gen_test/q
mkdir /root/gen_test/complex.js
mkdir /root/gen_test/pull-stream
mkdir /root/gen_test/memfs

python3 test_gen.py bluebird /root/api/bluebird_api.json
python3 test_gen.py q /root/api/q_api.json
python3 test_gen.py complex.js /root/api/complex.js_api.json
python3 test_gen.py pull-stream /root/api/pull-stream_api.json
python3 test_gen.py memfs /root/api/memfs_api.json


# run coverage

mkdir /root/eval
mkdir /root/eval/coverage

npm run test:eval /root/gen_test/bluebird/unit/*.js /root/gen_test/bluebird/branch/*.js > /root/eval/coverage/coverage_bluebird.log
npm run test:eval /root/gen_test/q/unit/*.js /root/gen_test/q/branch/*.js > /root/eval/coverage/coverage_q.log
npm run test:eval /root/gen_test/complex.js/unit/*.js /root/gen_test/complex.js/branch/*.js > /root/eval/coverage/coverage_complex.js.log
npm run test:eval /root/gen_test/pull-stream/unit/*.js /root/gen_test/pull-stream/branch/*.js > /root/eval/coverage/coverage_pull-stream.log
npm run test:eval /root/gen_test/memfs/unit/*.js /root/gen_test/memfs/branch/*.js > /root/eval/coverage/coverage_memfs.log
