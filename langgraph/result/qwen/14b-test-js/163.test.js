// Source Code
function generateIntegers(a, b) {
    const lower = Math.max(2, Math.min(a, b));
    const upper = Math.min(8, Math.max(a, b));

    const result = [];
    for (let i = lower; i <= upper; i++) {
        if (i % 2 === 0) {
            result.push(i);
        }
    }
    return result;
}

// Transformed Code (Semantically Equivalent)
function produceEvenNumbers(x, y) {
    let start = Math.max(2, Math.min(x, y));
    let end = Math.min(8, Math.max(x, y));

    let evenNumbers = [];
    let current = start;
    while (current <= end) {
        if (current % 2 === 0) {
            evenNumbers.push(current);
        }
        current += 1;
    }

    return evenNumbers;
}

// Test Cases
describe('generateIntegers vs produceEvenNumbers equivalence tests', () => {
    const testCases = [
        [1, 5],
        [3, 9],
        [6, 2],
        [8, 8],
        [0, 4],
        [7, 7],
        [2, 2],
        [10, 1],
        [5, 5],
        [4, 4]
    ];

    test.each(testCases)('Input: (%d, %d)', (a, b) => {
        expect(generateIntegers(a, b)).toEqual(produceEvenNumbers(a, b));
    });
});