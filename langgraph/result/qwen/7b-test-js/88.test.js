// Source Code
function sortArray(array) {
    return array.length === 0 ? [] : (array[0] + array[array.length - 1]) % 2 === 0 ? array.sort((a, b) => b - a) : array.sort((a, b) => a - b);
}

// Transformed Code (Semantically Equivalent)
function arrangeSequence(array) {
    if (!array.length) {
        return [];
    }
    
    let reverseOrder = (array[0] + array[array.length - 1]) % 2 === 0;
    return array.sort((a, b) => reverseOrder ? b - a : a - b);
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

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(sortArray([...inputArray])).toBe(JSON.stringify(arrangeSequence([...inputArray])));
    });
});