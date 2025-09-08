function generateIntegers(a, b) {
    let lower = Math.max(2, Math.min(a, b));
    let upper = Math.min(8, Math.max(a, b));

    return Array.from({ length: upper - lower + 1 }, (_, i) => i + lower).filter(i => i % 2 === 0);
}