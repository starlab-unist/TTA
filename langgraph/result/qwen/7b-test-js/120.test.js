// Source Code
function maximum(arr, k) {
    if (k === 0) {
        return [];
    }
    arr.sort((a, b) => a - b);
    let ans = arr.slice(-k);
    return ans;
}

// Transformed Code (Semantically Equivalent)
function findTopKElements(sequence, count) {
    if (count === 0) {
        return [];
    }

    let sortedSequence = [...sequence].sort((a, b) => a - b);
    let topElements = sortedSequence.slice(-count);

    return topElements;
}

// Test Cases
describe('maximum vs findTopKElements equivalence tests', () => {
    const testCases = [
        [[1, 2, 3, 4, 5], 3],
        [[5, 4, 3, 2, 1], 2],
        [[10, 9, 8, 7, 6], 5],
        [[1, 1, 1, 1, 1], 3],
        [[], 1],
        [[1, 2, 3], 0],
        [[-1, -2, -3, -4], 2],
        [[100, 200, 300, 400, 500], 0],
        [[5, 5, 5, 5, 5, 5], 6],
        [[10, 20, 30, 40, 50], 1]
    ];

    test.each(testCases)('Input: array=%p, k=%i', (inputArray, inputK) => {
        expect(maximum(inputArray, inputK)).toEqual(findTopKElements(inputArray, inputK));
    });
});