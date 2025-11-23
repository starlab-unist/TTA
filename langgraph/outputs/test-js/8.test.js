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
        [],
        [0],
        [1],
        [1, 2],
        [2, 3],
        [-1, 2],
        [0, 1, 2],
        [1, 0, 2],
        [1, 2, 3],
        [-1, -2, -3]
    ];

    test.each(testCases)('Input: %p', (input) => {
        expect(sumProduct(input)).toEqual(calculateAggregates(input));
    });
});