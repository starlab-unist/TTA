function fizzBuzz(n) {
    const ns = [];
    for (let i = 0; i < n; i++) {
        if (i % 11 === 0 || i % 13 === 0) {
            ns.push(i);
        }
    }
    const s = ns.join('');
    let ans = 0;
    for (const c of s) {
        if (c === '7') {
            ans++;
        }
    }
    return ans;
}