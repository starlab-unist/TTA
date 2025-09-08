// Source Code
function meanAbsoluteDeviation(numbers) {
    const mean = numbers.reduce((acc, num) => acc + num, 0) / numbers.length;
    return numbers.reduce((acc, num) => acc + Math.abs(num - mean), 0) / numbers.length;
}

// Transformed Code (Semantically Equivalent)
function calculateMeanAbsoluteDev(values) {
    const average = values.reduce((sum, value) => sum + value, 0) / values.length;
    let deviationSum = 0;
    values.forEach(value => {
        deviationSum += Math.abs(value - average);
    });
    return deviationSum / values.length;
}

console.log(calculateMeanAbsoluteDev([1, 2, 3, 4, 5]));

// Test Cases
describe('meanAbsoluteDeviation vs calculateMeanAbsoluteDev equivalence tests', () => {
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
        it(`test_${index}`, () => {
            expect(meanAbsoluteDeviation(input)).toBeCloseTo(expected);
            expect(calculateMeanAbsoluteDev(input)).toBeCloseTo(expected);
        });
    });
});