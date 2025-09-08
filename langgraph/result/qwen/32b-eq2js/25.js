function decomposeNumber(number) {
    const factors = [];
    let divisor = 2;
    while (divisor <= Math.floor(Math.sqrt(number))) {
        if (number % divisor === 0) {
            factors.push(divisor);
            number = Math.floor(number / divisor);
        } else {
            divisor += 1;
        }
    }

    if (number > 1) {
        factors.push(number);
    }
    return factors;
}

// method name: factorize -> decomposeNumber
// parameter name: n -> number
// variable name: fact -> factors, i -> divisor
// replaced math.isqrt(number) with Math.floor(Math.sqrt(number)) for integer square root
// kept the logic and structure similar but changed identifiers and added a comment about the integer square root