function findMaxPrimeDivisor(number) {
    function checkPrime(candidate) {
        if (candidate < 2) {
            return false;
        }
        let divisor = 2;
        while (divisor * divisor <= candidate) {
            if (candidate % divisor === 0) {
                return false;
            }
            divisor += 1;
        }
        return true;
    }

    let maxPrime = 1;
    let factor = 2;
    while (factor <= number) {
        if (number % factor === 0 && checkPrime(factor)) {
            maxPrime = factor;
        }
        factor += 1;
    }
    return maxPrime;
}

// method name: findMaxPrimeDivisor
// parameter name: number
// inner function name: checkPrime
// variable name: maxPrime -> maxPrime, factor -> factor
// replaced for loop with while loop for factorization
// optimized prime checking by iterating only up to the square root of the candidate