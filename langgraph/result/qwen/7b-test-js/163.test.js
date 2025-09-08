// Source Code
function generateIntegers(a, b) {
    let lower = Math.max(2, Math.min(a, b));
    let upper = Math.min(8, Math.max(a, b));

    return Array.from({ length: upper - lower + 1 }, (_, i) => lower + i).filter(i => i % 2 === 0);
}

// Transformed Code (Semantically Equivalent)
function produceEvenNumbers(a, b) {
    let start = Math.max(2, Math.min(a, b));
    let end = Math.min(8, Math.max(a, b));

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

    test.each(testCases)('Input: (%i, %i)', (a, b) => {
        expect(generateIntegers(a, b)).toEqual(produceEvenNumbers(a, b));
    });
});