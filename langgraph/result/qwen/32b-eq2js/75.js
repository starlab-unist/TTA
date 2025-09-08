function checkProductOfThreePrimes(number) {
    function primeCheck(value) {
        for (let divisor = 2; divisor < value; divisor++) {
            if (value % divisor === 0) {
                return false;
            }
        }
        return true;
    }

    const primeRange = Array.from({ length: 100 - 2 + 1 }, (_, i) => i + 2);
    for (let first of primeRange) {
        if (!primeCheck(first)) {
            continue;
        }
        for (let second of primeRange) {
            if (!primeCheck(second)) {
                continue;
            }
            for (let third of primeRange) {
                if (!primeCheck(third)) {
                    continue;
                }
                if (first * second * third === number) {
                    return true;
                }
            }
        }
    }
    return false;
}