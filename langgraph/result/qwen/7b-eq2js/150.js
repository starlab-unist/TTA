function determineValueBasedOnDivisibility(n, x, y) {
    if (n === 1) {
        return y;
    }

    let divisor = 2;
    while (divisor < n) {
        if (n % divisor === 0) {
            return y;
        }
        divisor += 1;
    }
    return x;
}