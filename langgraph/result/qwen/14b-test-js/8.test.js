// Source Code
function sumProduct(numbers) {
    let sumValue = 0;
    let prodValue = 1;

    for (let n of numbers) {
        sumValue += n;
        prodValue *= n;
    }
    return [sumValue, prodValue];
}

// Transformed Code (Semantically Equivalent)
function calculateAggregates(values) {
    let totalSum = 0;
    let cumulativeProduct = 1;

    let index = 0;
    while (index < values.length) {
        totalSum += values[index];
        cumulativeProduct *= values[index];
        index += 1;
    }

    return [totalSum, cumulativeProduct];
}

// Test Cases
describe('sumProduct vs calculateAggregates equivalence tests', () => {
    const testCases = [
        { input: [], expected: [0, 1] },
        { input: [1], expected: [1, 1] },
        { input: [2, 3], expected: [5, 6] },
        { input: [4, 5, 6], expected: [15, 120] },
        { input: [7, 8, 9, 10], expected: [34, 5040] },
        { input: [0, 1, 2, 3], expected: [6, 0] },
        { input: [1, -1, 1, -1], expected: [0, 1] },
        { input: [10, 20, 30], expected: [60, 6000] },
        { input: [5, 5, 5, 5], expected: [20, 625] },
        { input: [1, 2, 3, 4, 5], expected: [15, 120] }
    ];

    test.each(testCases)('Input: %j', ({ input, expected }) => {
        expect(sumProduct(input)).toEqual(calculateAggregates(input));
    });
});