function isMultiplyPrime(a) {
    function isPrime(n) {
        for (let j = 2; j < n; j++) {
            if (n % j === 0) {
                return false;
            }
        }
        return true;
    }

    for (let i = 2; i <= 100; i++) {
        if (!isPrime(i)) continue;
        for (let j = 2; j <= 100; j++) {
            if (!isPrime(j)) continue;
            for (let k = 2; k <= 100; k++) {
                if (!isPrime(k)) continue;
                if (i * j * k === a) return true;
            }
        }
    }
    return false;
}