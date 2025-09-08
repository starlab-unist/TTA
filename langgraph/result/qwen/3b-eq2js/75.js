function checkProductOfThreePrimes(number) {
    function primeCheck(value) {
        for (let divisor = 2; divisor < value; divisor++) {
            if (value % divisor === 0) {
                return false;
            }
        }
        return true;
    }

    const primeRange = Array.from({ length: 100 }, (_, i) => i + 2);
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

// method name: is_multiply_prime -> checkProductOfThreePrimes
// parameter name: a -> number
// inner function name: is_prime -> primeCheck
// variable name: i -> first, j -> second, k -> third
// changed the range variable name to primeRange for clarity
// kept the nested loop structure but added comments for clarity