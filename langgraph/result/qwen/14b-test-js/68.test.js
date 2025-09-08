// Source Code
function pluck(arr) {
    if (arr.length === 0) return [];
    const evens = arr.filter(x => x % 2 === 0);
    if (evens.length === 0) return [];
    const minEven = Math.min(...evens);
    return [minEven, arr.indexOf(minEven)];
}

// Transformed Code (Semantically Equivalent)
function extractMinEvenAndIndex(sequence) {
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
describe('pluck vs extractMinEvenAndIndex equivalence tests', () => {
    const testCases = [
        [[1, 2, 3, 4, 5], [2, 1]],
        [[10, 21, 3, 7, 8], [8, 4]],
        [[], []],
        [[1, 3, 5, 7], []],
        [[2, 4, 6, 8], [2, 0]],
        [[9, 7, 5, 3, 2, 4, 6, 8], [2, 4]],
        [[0, 1, 2, 3, 4, 5], [0, 0]],
        [[11, 13, 17, 19, 23, 29, 2], [2, 6]],
        [[8, 6, 4, 2, 0], [0, 4]],
        [[2, 2, 2, 2, 2], [2, 0]]
    ];

    test.each(testCases)('Input: %j', (inputArray, expectedOutput) => {
        expect(pluck(inputArray)).toBe(expectedOutput);
        expect(extractMinEvenAndIndex(inputArray)).toBe(expectedOutput);
        expect(pluck(inputArray)).toEqual(extractMinEvenAndIndex(inputArray));
    });
});