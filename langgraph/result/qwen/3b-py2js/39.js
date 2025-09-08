function primeFib(n) {
    function isPrime(p) {
        if (p < 2) return false;
        for (let k = 2; k <= Math.min(Math.sqrt(p), p - 1); k++) {
            if (p % k === 0) return false;
        }
        return true;
    }

    let f = [0, 1];
    while (true) {
        f.push(f[f.length - 1] + f[f.length - 2]);
        if (isPrime(f[f.length - 1])) {
            n -= 1;
        }
        if (n === 0) return f[f.length - 1];
    }
}