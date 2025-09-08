// Source Code
function unique(arr) {
    return [...new Set(arr)].sort();
}

// Transformed Code (Semantically Equivalent)
function extractDistinctElements(inputList) {
    const distinctElements = new Set(inputList);
    const sortedElements = Array.from(distinctElements).sort();
    return sortedElements;
}

// Test Cases
describe('unique vs extractDistinctElements equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5, 5, 6],
        ['a', 'b', 'c', 'a', 'b'],
        [],
        [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5],
        ['apple', 'banana', 'cherry', 'apple', 'date'],
        [true, false, true, true, false], // Note: JavaScript uses `true` and `false` in lowercase
        [1.1, 2.2, 3.3, 2.2, 1.1],
        ['same', 'same', 'different'],
        ['value'],
        ['single']
    ];

    test.each(testCases)('Input: %p', (inputList) => {
        expect(unique(inputList)).toEqual(extractDistinctElements(inputList));
    });
});