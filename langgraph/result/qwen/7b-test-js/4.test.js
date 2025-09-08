// Source Code
function meanAbsoluteDeviation(numbers) {
    const mean = numbers.reduce((acc, val) => acc + val, 0) / numbers.length;
    return numbers.reduce((acc, val) => acc + Math.abs(val - mean), 0) / numbers.length;
}

// Transformed Code (Semantically Equivalent)
function calculateMeanAbsDev(values) {
    const average = values.reduce((acc, val) => acc + val, 0) / values.length;
    const deviationSum = values.reduce((acc, val) => acc + Math.abs(val - average), 0);
    return deviationSum / values.length;
}

// Test Cases
describe('meanAbsoluteDeviation vs calculateMeanAbsDev equivalence tests', () => {
    const testCases = [
        ([1.0, 2.0, 3.0], 0.6666666666666666),
        ([4.0, 5.0, 6.0, 7.0], 1.0),
        ([10.0, 10.0, 10.0], 0.0),
        ([1.0, 1.0, 2.0, 3.0, 4.0], 1.2),
        ([5.5, 5.5, 5.5, 5.5], 0.0),
        ([1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], 2.5),
        ([0.0, 0.0, 0.0, 0.0, 0.0], 0.0),
        ([1.5, 2.5, 3.5, 4.5, 5.5], 1.2),
        ([100.0, 200.0, 300.0], 66.66666666666667),
        ([1.1, 2.2, 3.3, 4.4, 5.5], 1.32)
    ];

    testCases.forEach(([input, expected], index) => {
        it(`test case ${index}`, () => {
            expect(meanAbsoluteDeviation(input)).toBeCloseTo(expected);
            expect(calculateMeanAbsDev(input)).toBeCloseTo(expected);
        });
    });
});