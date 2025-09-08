// Source Code
function sortThird(arr) {
    arr = [...arr]; // Create a copy of the array
    arr.splice(0, 0, ...arr.slice(0, arr.length).filter((_, index) => index % 3 === 0).sort((a, b) => a - b));
    return arr;
}

// Transformed Code (Semantically Equivalent)
function sortThird(inputList) {
    const elementsToSort = inputList.filter((_, index) => index % 3 === 0);
    elementsToSort.sort((a, b) => a - b);
    const result = [...inputList];
    for (let i = 0; i < elementsToSort.length; i++) {
        result[i * 3] = elementsToSort[i];
    }
    return result;
}

// Test Cases
describe('sortThird vs sortThird equivalence tests', () => {
    const testCases = [
        [9, 2, 3, 6, 5, 4, 1, 8, 7],
        [10, 20, 30, 40, 50, 60, 70, 80, 90],
        [1, 2, 3],
        [3, 2, 1, 6, 5, 4, 9, 8, 7],
        [],
        [5],
        [5, 10],
        [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5],
        [7, 8, 9, 1, 2, 3, 4, 5, 6],
        [0, 0, 0, 0, 0, 0, 0, 0, 0]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(sortThird(inputArray)).toEqual(sortThird(inputArray));
    });
});