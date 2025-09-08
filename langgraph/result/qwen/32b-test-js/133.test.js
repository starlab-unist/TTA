// Source Code
function sumSquares(lst) {
    let squared = 0;
    for (let i of lst) {
        squared += Math.ceil(i) ** 2;
    }
    return squared;
}

// Transformed Code (Semantically Equivalent)
function calculateTotalSquaredCeilings(numbers) {
    let total = 0;
    let iterator = numbers[Symbol.iterator]();
    while (true) {
        let result = iterator.next();
        if (result.done) {
            break;
        }
        let number = result.value;
        total += Math.ceil(number) ** 2;
    }
    return total;
}

// Test Cases
describe('sumSquares vs calculateTotalSquaredCeilings equivalence tests', () => {
    const testCases = [
        [1, 2, 3],
        [-1.5, 2.3, -3.7],
        [0, 0, 0],
        [4.9, 5.1, 6.5],
        [10, -10, 20],
        [1.1, 1.9, 2.5],
        [-1, -2, -3],
        [],
        [0.99, 1.01, 2.99],
        [5]
    ];

    test.each(testCases)('Input: %j', (inputList) => {
        expect(sumSquares(inputList)).toBe(calculateTotalSquaredCeilings(inputList));
    });
});