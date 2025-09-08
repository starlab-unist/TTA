// Source Code
function unique(arr) {
    return arr.filter((value, index, self) => self.indexOf(value) === index).sort();
}

// Transformed Code (Semantically Equivalent)
function extractDistinctElements(l) {
    let distinctElements = new Set(l);
    let sortedElements = Array.from(distinctElements).sort();
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
        [true, false, true, true, false],
        [1.1, 2.2, 3.3, 2.2, 1.1],
        ['same', 'same', 'different'],
        ['value'],  
        ['single']
    ];

    test.each(testCases)('Input: %s', (inputArray) => {
        expect(unique(inputArray)).toEqual(extractDistinctElements(inputArray));
    });
});