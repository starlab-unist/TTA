function calculateSpecialNumber(n) {
    if (n === 1) {
        return 1;
    }
    const multiplier = 18;
    const base = Math.pow(10, n - 2);
    return multiplier * base;
}