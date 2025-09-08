// Source Code
function roundedAvg(n, m) {
    if (m < n) {
        return -1;
    }
    let summation = 0;
    for (let i = n; i <= m; i++) {
        summation += i;
    }
    return (Math.round(summation / (m - n + 1))).toString(2);
}

// Transformed Code (Semantically Equivalent)
function calculateBinaryAverage(start, end) {
    if (end < start) {
        return -1;
    }
    let totalSum = 0;
    let current = start;
    while (current <= end) {
        totalSum += current;
        current += 1;
    }
    const average = Math.round(totalSum / (end - start + 1));
    return average.toString(2);
}

// Test Cases
describe('roundedAvg vs calculateBinaryAverage equivalence tests', () => {
    const testCases = [
        [1, 5],       // Simple range
        [0, 0],       // Single element range
        [-2, 2],      // Range with negative numbers
        [10, 10],     // Single element range at higher number
        [5, 1],       // Invalid range where end < start
        [-5, -1],     // Negative range
        [1, 100],     // Larger range
        [10, 20],     // Another simple range
        [20, 30],     // Another simple range
        [100, 200]    // Larger range
    ];

    test.each(testCases)('Input: n=%d, m=%d', (n, m) => {
        expect(roundedAvg(n, m)).toBe(calculateBinaryAverage(n, m));
    });
});