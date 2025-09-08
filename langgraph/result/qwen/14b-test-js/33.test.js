// Source Code
function sortThird(arr) {
    arr = [...arr];
    arr.filter((_, index) => index % 3 === 0).sort().forEach((value, index) => {
        arr[index * 3] = value;
    });
    return arr;
}

// Transformed Code (Semantically Equivalent)
function arrangeEveryThirdElement(inputList) {
    const elementsToSort = inputList.filter((_, index) => index % 3 === 0);
    elementsToSort.sort((a, b) => a - b);
    const resultList = [...inputList];
    elementsToSort.forEach((value, index) => {
        resultList[index * 3] = value;
    });
    return resultList;
}

// Test Cases
describe('sortThird vs arrangeEveryThirdElement equivalence tests', () => {
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
        expect(sortThird(inputArray)).toEqual(arrangeEveryThirdElement(inputArray));
    });
});