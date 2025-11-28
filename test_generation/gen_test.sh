ROOT_DIR="/home/starlab1/TTA/test_generation"

# env setup

source "$ROOT_DIR/test-env/bin/activate"

export NVM_DIR="$([ -z "${XDG_CONFIG_HOME-}" ] && printf %s "${HOME}/.nvm" || printf %s "${XDG_CONFIG_HOME}/nvm")"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
nvm use 16

# extract APIs for each project

cd "$ROOT_DIR"
mkdir "$ROOT_DIR/api"

node exploreAPI.js "$ROOT_DIR/projects/bluebird" "$ROOT_DIR/api/bluebird_api.json"
node exploreAPI.js "$ROOT_DIR/projects/q" "$ROOT_DIR/api/q_api.json"
node exploreAPI.js "$ROOT_DIR/projects/pull-stream" "$ROOT_DIR/api/pull-stream_api.json"
node exploreAPI.js "$ROOT_DIR/projects/Complex.js" "$ROOT_DIR/api/complex.js.json"
node exploreAPI.js "$ROOT_DIR/projects/memfs" "$ROOT_DIR/api/memfs_api.json"


# run experiment

cd "$ROOT_DIR"
mkdir "$ROOT_DIR/gen_test"

mkdir "$ROOT_DIR/gen_test/bluebird"
mkdir "$ROOT_DIR/gen_test/q"
mkdir "$ROOT_DIR/gen_test/complex.js"
mkdir "$ROOT_DIR/gen_test/pull-stream"
mkdir "$ROOT_DIR/gen_test/memfs"

python3 test_gen.py bluebird "$ROOT_DIR/api/bluebird_api.json"
python3 test_gen.py q "$ROOT_DIR/api/q_api.json"
python3 test_gen.py complex.js "$ROOT_DIR/api/complex.js.json"
python3 test_gen.py pull-stream "$ROOT_DIR/api/pull-stream_api.json"
python3 test_gen.py memfs "$ROOT_DIR/api/memfs_api.json"


# run coverage

mkdir "$ROOT_DIR/eval"
mkdir "$ROOT_DIR/eval/coverage"


cd "$ROOT_DIR/projects/bluebird"
npm run prepublish
cd "$ROOT_DIR"
npm run test:eval "$ROOT_DIR/gen_test/bluebird/unit/*.js" "$ROOT_DIR/gen_test/bluebird/branch/*.js" > "$ROOT_DIR/eval/coverage/coverage_bluebird.log"

cd "$ROOT_DIR/projects/q"
npm run prepublish
cd "$ROOT_DIR"
npm run test:eval "$ROOT_DIR/gen_test/q/unit/*.js" "$ROOT_DIR/gen_test/q/branch/*.js" > "$ROOT_DIR/eval/coverage/coverage_q.log"


npm run test:eval "$ROOT_DIR/gen_test/complex.js/unit/*.js" "$ROOT_DIR/gen_test/complex.js/branch/*.js" > "$ROOT_DIR/eval/coverage/coverage_complex.js.log"

npm run test:eval "$ROOT_DIR/gen_test/pull-stream/unit/*.js" "$ROOT_DIR/gen_test/pull-stream/branch/*.js" > "$ROOT_DIR/eval/coverage/coverage_pull-stream.log"

npm run test:eval "$ROOT_DIR/gen_test/memfs/unit/*.js" "$ROOT_DIR/gen_test/memfs/branch/*.js" > "$ROOT_DIR/eval/coverage/coverage_memfs.log"
