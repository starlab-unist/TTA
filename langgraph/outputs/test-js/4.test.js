function meanAbsoluteDeviation(numbers) {
    const mean = numbers.reduce((acc, val) => acc + val, 0) / numbers.length;
    return numbers.reduce((acc, val) => acc + Math.abs(val - mean), 0) / numbers.length;
}

function calculateMeanAbsDev(values) {
    const average = values.reduce((sum, value) => sum + value, 0) / values.length;
    const deviationSum = values.reduce((sum, value) => sum + Math.abs(value - average), 0);
    return deviationSum / values.length;
}

describe('meanAbsoluteDeviation vs calculateMeanAbsDev equivalence tests', () => {
    const testCases = [
        [1, 1, 1],
        [2, 2],
        [1, 3],
        [0, 0, 0],
        [5, 5, 5, 5]
    ];

    test.each(testCases)('Input: %j', (numbers) => {
        expect(meanAbsoluteDeviation(numbers)).toBe(calculateMeanAbsDev(numbers));
    });
});