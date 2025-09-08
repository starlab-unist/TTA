// Source Code
function sumSquares(arr) {
    let squared = 0;
    for (let i of arr) {
        squared += Math.pow(Math.ceil(i), 2);
    }
    return squared;
}

// Transformed Code (Semantically Equivalent)
function calculateTotalSquaredCeilings(lst) {
    const math = require('mathjs');
    let total = 0;
    let iterator = lst[Symbol.iterator]();
    while (true) {
        try {
            let number = iterator.next().value;
            if (number === undefined) break;
            total += Math.pow(math.ceil(number), 2);
        } catch (e) {
            break;
        }
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

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(sumSquares(inputArray)).toBe(calculateTotalSquaredCeilings(inputArray));
    });
});