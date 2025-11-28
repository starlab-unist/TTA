ROOT_DIR="/home/starlab1/TTA/test_generation"

# python env setup

python3 -m venv test-env
source test-env/bin/activate
pip install --upgrade pip
pip install -r requirements.txt

# node env setup

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.3/install.sh | bash
export NVM_DIR="$([ -z "${XDG_CONFIG_HOME-}" ] && printf %s "${HOME}/.nvm" || printf %s "${XDG_CONFIG_HOME}/nvm")"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
nvm install 16
nvm use 16
nvm alias default 16

# collect & install projects

mkdir projects

cd "$ROOT_DIR/projects"
git clone https://github.com/petkaantonov/bluebird.git
cd "$ROOT_DIR/projects/bluebird"
git checkout 6c8c069

npm install
npm run prepublish

cd "$ROOT_DIR/projects"
git clone https://github.com/kriskowal/q.git
cd "$ROOT_DIR/projects/q"
git checkout 6bc7f52

npm install
npm run prepublish


cd "$ROOT_DIR/projects"
git clone https://github.com/rawify/Complex.js.git
cd "$ROOT_DIR/projects/Complex.js"
git checkout d995ca1

npm install


cd "$ROOT_DIR/projects"
git clone https://github.com/pull-stream/pull-stream.git
cd "$ROOT_DIR/projects/pull-stream"
git checkout 29b4868

npm install


cd "$ROOT_DIR/projects"
git clone https://github.com/streamich/memfs.git
cd "$ROOT_DIR/projects/memfs"
git checkout ec83e6f

npm install --legacy-peer-deps
npm run build


cd "$ROOT_DIR"
npm install
