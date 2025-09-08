function decomposeNumber(number) {
    let factors = [];
    let divisor = 2;
    while (divisor <= Math.floor(Math.sqrt(number))) {
        if (number % divisor === 0) {
            factors.push(divisor);
            number /= divisor;
        } else {
            divisor++;
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
// replaced Math.sqrt(n) + 1 with Math.floor(Math.sqrt(number)) for integer square root
// kept the logic and structure similar but changed identifiers and added a comment about the integer square root