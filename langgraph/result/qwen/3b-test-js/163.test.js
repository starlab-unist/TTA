// Source Code
function generateIntegers(a, b) {
    let lower = Math.max(2, Math.min(a, b));
    let upper = Math.min(8, Math.max(a, b));

    return Array.from({ length: upper - lower + 1 }, (_, i) => i + lower).filter(i => i % 2 === 0);
}

// Transformed Code (Semantically Equivalent)
function produceEvenNumbers(x, y) {
    const start = Math.max(2, Math.min(x, y));
    const end = Math.min(8, Math.max(x, y));

    const evenNumbers = [];
    let current = start;
    while (current <= end) {
        if (current % 2 === 0) {
            evenNumbers.push(current);
        }
        current++;
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

    test.each(testCases)('Input: a=%s, b=%s', (a, b) => {
        expect(generateIntegers(a, b)).toEqual(produceEvenNumbers(a, b));
    });
});