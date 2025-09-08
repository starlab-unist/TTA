// Source Code
function sortArray(array) {
    return array.length === 0 ? [] : array.sort((a, b) => ((array[0] + array[array.length - 1]) % 2 === 0) ? b - a : a - b);
}

// Transformed Code (Semantically Equivalent)
function arrangeSequence(sequence) {
    if (sequence.length === 0) {
        return [];
    }
    
    const reverseOrder = (sequence[0] + sequence[sequence.length - 1]) % 2 === 0;
    return sequence.slice().sort((a, b) => reverseOrder ? b - a : a - b);
}

// Test Cases
describe('sortArray vs arrangeSequence equivalence tests', () => {
    const testCases = [
        [3, 1, 4, 1, 5, 9],
        [10, 20, 30, 40, 50],
        [5, 3, 8, 6, 7, 2],
        [7, 2, 9, 4, 6],
        [1],
        [],
        [2, 4, 6, 8, 10],
        [9, 7, 5, 3, 1],
        [11, 22, 33, 44, 55],
        [100, 200, 300, 400, 500]
    ];

    test.each(testCases)('Input: %j', (inputArray) => {
        expect(sortArray(inputArray)).toEqual(arrangeSequence(inputArray))
    });
});