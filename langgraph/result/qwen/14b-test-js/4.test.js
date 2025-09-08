// Source Code
function meanAbsoluteDeviation(numbers) {
    const mean = numbers.reduce((sum, num) => sum + num, 0) / numbers.length;
    return numbers.reduce((sum, num) => sum + Math.abs(num - mean), 0) / numbers.length;
}

// Transformed Code (Semantically Equivalent)
function calculateMeanAbsDev(values) {
    const average = values.reduce((sum, value) => sum + value, 0) / values.length;
    const deviationSum = values.reduce((sum, value) => sum + Math.abs(value - average), 0);
    return deviationSum / values.length;
}

// Test Cases
describe('meanAbsoluteDeviation vs calculateMeanAbsDev equivalence tests', () => {
    const testCases = [
        { input: [1.0, 2.0, 3.0], expected: 0.6666666666666666 },
        { input: [4.0, 5.0, 6.0, 7.0], expected: 1.0 },
        { input: [10.0, 10.0, 10.0], expected: 0.0 },
        { input: [1.0, 1.0, 2.0, 3.0, 4.0], expected: 1.2 },
        { input: [5.5, 5.5, 5.5, 5.5], expected: 0.0 },
        { input: [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], expected: 2.5 },
        { input: [0.0, 0.0, 0.0, 0.0, 0.0], expected: 0.0 },
        { input: [1.5, 2.5, 3.5, 4.5, 5.5], expected: 1.2 },
        { input: [100.0, 200.0, 300.0], expected: 66.66666666666667 },
        { input: [1.1, 2.2, 3.3, 4.4, 5.5], expected: 1.32 }
    ];

    testCases.forEach(({ input, expected }, index) => {
        it(`Test case ${index}`, () => {
            expect(meanAbsoluteDeviation(input)).toBeCloseTo(expected);
            expect(calculateMeanAbsDev(input)).toBeCloseTo(expected);
        });
    });
});