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
        index++;
    }

    return [totalSum, cumulativeProduct];
}

// Test Cases
describe('sumProduct vs calculateAggregates equivalence tests', () => {
    const testCases = [
        [[], [0, 1]],
        [[1], [1, 1]],
        [[2, 3], [5, 6]],
        [[4, 5, 6], [15, 120]],
        [[7, 8, 9, 10], [34, 5040]],
        [[0, 1, 2, 3], [6, 0]],
        [[1, -1, 1, -1], [0, 1]],
        [[10, 20, 30], [60, 6000]],
        [[5, 5, 5, 5], [20, 625]],
        [[1, 2, 3, 4, 5], [15, 120]]
    ];

    test.each(testCases)('Input: %j', (inputArray, expectedOutput) => {
        expect(sumProduct(inputArray)).toEqual(calculateAggregates(inputArray));
    });
});