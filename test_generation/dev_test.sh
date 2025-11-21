mkdir /root/eval/dev

cd /root/projects/bluebird
npx istanbul cover tools/test.js -- --expose-gc > /root/eval/dev/coverage_bluebird.log

cd /root/projects/q
npm install --save-dev nyc
npx nyc jasmine-node spec && nyc report --reporter=html && opener coverage/index.html > /root/eval/dev/coverage_q.log

cd /root/projects/Complex.js
npx nyc mocha tests/*.js > /root/eval/dev/coverage_complex.js.log

cd /root/projects/memfs
npm run test:coverage > /root/eval/dev/coverage_memfs.log

cd /root/projects/pull-stream
nyc npm test > /root/eval/dev/coverage_pull-stream.log
