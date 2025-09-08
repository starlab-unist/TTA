function primeFib(n) {
    function isPrime(p) {
        if (p < 2) {
            return false;
        }
        for (let k = 2; k <= Math.min(Math.floor(Math.sqrt(p)) + 1, p - 1); k++) {
            if (p % k === 0) {
                return false;
            }
        }
        return true;
    }

    const f = [0, 1];
    while (true) {
        f.push(f[f.length - 1] + f[f.length - 2]);
        if (isPrime(f[f.length - 1])) {
            n--;
        }
        if (n === 0) {
            return f[f.length - 1];
        }
    }
}