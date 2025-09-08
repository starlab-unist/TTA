function calculateSpecialNumber(length) {
    if (length === 1) {
        return 1;
    }
    const multiplier = 18;
    const base = Math.pow(10, length - 2);
    return multiplier * base;
}