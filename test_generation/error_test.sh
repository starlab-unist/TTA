# apply bug patch

cd /root

cp -r /root/projects /root/buggy

cd /root/buggy/bluebird
patch -p2 < /root/patch/bluebird.diff

cd /root/buggy/q
patch -p2 < /root/patch/q.diff

cd /root/buggy/Complex.js
patch -p2 < /root/patch/Complex.js.diff

cd /root/buggy/pull-stream
patch -p2 < /root/patch/pull-stream.diff

cd /root/buggy/memfs
patch -p2 < /root/patch/memfs.diff


# run test on buggy projects

mkdir /root/eval/error

npx mocha /gen_test/bluebird/*/test_bluebird.prototype.nodeify*js > /root/eval/error/test_bluebird.prototype.nodeify.log
npx mocha /gen_test/bluebird/*/test_bluebird.prototype.then*js > /root/eval/error/test_bluebird.prototype.then.log

npx mocha /gen_test/q/*/test_q.makePromise.prototype.done*js > /root/eval/error/test_q.makePromise.prototype.done.log
npx mocha /gen_test/q/*/test_q.denodeify*js > /root/eval/error/test_q.denodeify.log

npx mocha /gen_test/pull-stream/*/test_pull-stream.once*js > /root/eval/error/test_pull-stream.once.log
npx mocha /gen_test/pull-stream/*/test_pull-stream.filter*js > /root/eval/error/test_pull-stream.filter.log

npx mocha /gen_test/complex.js/*/test_complex.js.ZERO.toString*js > /root/eval/error/test_complex.js.ZERO.toString.log
npx mocha /gen_test/complex.js/*/test_complex.js.ZERO.round*js > /root/eval/error/test_complex.js.ZERO.round.log

npx mocha /gen_test/complex.js/*/test_complex.js.ZERO.toString*js > /root/eval/error/test_complex.js.ZERO.toString.log
npx mocha /gen_test/complex.js/*/test_complex.js.ZERO.round*js > /root/eval/error/test_complex.js.ZERO.round.log

