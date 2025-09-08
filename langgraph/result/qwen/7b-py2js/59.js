function largestPrimeFactor(n) {
    function isPrime(k) {
        if (k < 2) {
            return false;
        }
        for (let i = 2; i <= Math.sqrt(k); i++) {
            if (k % i === 0) {
                return false;
            }
        }
        return true;
    }
    let largest = 1;
    for (let j = 2; j <= n; j++) {
        if (n % j === 0 && isPrime(j)) {
            largest = Math.max(largest, j);
        }
    }
    return largest;
}