function checkProductOfThreePrimes(a) {
    function isPrime(value) {
        for (let divisor = 2; divisor < value; divisor++) {
            if (value % divisor === 0) {
                return false;
            }
        }
        return true;
    }

    const primeRange = Array.from({ length: 100 }, (_, i) => i + 2);
    for (const first of primeRange) {
        if (!isPrime(first)) continue;
        for (const second of primeRange) {
            if (!isPrime(second)) continue;
            for (const third of primeRange) {
                if (!isPrime(third)) continue;
                if (first * second * third === a) {
                    return true;
                }
            }
        }
    }
    return false;
}