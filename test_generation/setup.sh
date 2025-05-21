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

# ollama install

curl -fsSL https://ollama.com/install.sh | sh
nohup ollama serve > ollama.log &
echo "Waiting for Ollama to start..."
for i in {1..10}; do
  if curl -s http://localhost:11434 > /dev/null; then
    echo "Ollama is up!"
    break
  fi
  sleep 1
done
ollama pull qwen2.5:72b

# collect & install projects

mkdir projects

cd /root/projects
git clone https://github.com/petkaantonov/bluebird.git
cd /root/projects/bluebird
git checkout 6c8c069

npm install
npm run prepublish

cd /root/projects
git clone https://github.com/kriskowal/q.git
cd /root/projects/q
git checkout 6bc7f52

npm install
npm run prepublish


cd /root/projects
git clone https://github.com/rawify/Complex.js.git
cd /root/projects/Complex.js
git checkout d995ca1

npm install


cd /root/projects/
git clone https://github.com/pull-stream/pull-stream.git
cd /root/projects/pull-stream
git checkout 29b4868

npm install


cd /root/projects/
git clone https://github.com/streamich/memfs.git
cd /root/projects/memfs
git checkout ec83e6f

npm install --legacy-peer-deps
npm run build


cd /root
npm install

