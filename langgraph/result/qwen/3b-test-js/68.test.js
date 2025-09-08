// Source Code
function pluck(arr) {
    if (arr.length === 0) return [];
    const evens = arr.filter(x => x % 2 === 0);
    if (evens.length === 0) return [];
    const minEven = Math.min(...evens);
    const index = arr.indexOf(minEven);
    return [minEven, index];
}

// Transformed Code (Semantically Equivalent)
function pluck(sequence) {
    if (!sequence.length) {
        return [];
    }

    const evenNumbers = sequence.filter(num => num % 2 === 0);
    if (!evenNumbers.length) {
        return [];
    }

    const smallestEven = Math.min(...evenNumbers);
    const positionOfSmallestEven = sequence.indexOf(smallestEven);

    return [smallestEven, positionOfSmallestEven];
}

// Test Cases
describe('pluck vs pluck equivalence tests', () => {
    const testCases = [
        { input: [1, 2, 3, 4, 5], expected: [2, 1] },
        { input: [10, 21, 3, 7, 8], expected: [8, 4] },
        { input: [], expected: [] },
        { input: [1, 3, 5, 7], expected: [] },
        { input: [2, 4, 6, 8], expected: [2, 0] },
        { input: [9, 7, 5, 3, 2, 4, 6, 8], expected: [2, 4] },
        { input: [0, 1, 2, 3, 4, 5], expected: [0, 0] },
        { input: [11, 13, 17, 19, 23, 29, 2], expected: [2, 6] },
        { input: [8, 6, 4, 2, 0], expected: [0, 4] },
        { input: [2, 2, 2, 2, 2], expected: [2, 0] }
    ];

    test.each(testCases)('Input: "%s"', ({ input, expected }) => {
        expect(pluck(input)).toBe(JSON.stringify(expected));
        expect(pluck(sequence)(input)).toBe(JSON.stringify(expected));
    });
});