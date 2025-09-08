function generateIntegers(a, b) {
    const lower = Math.max(2, Math.min(a, b));
    const upper = Math.min(8, Math.max(a, b));

    const result = [];
    for (let i = lower; i <= upper; i++) {
        if (i % 2 === 0) {
            result.push(i);
        }
    }
    return result;
}