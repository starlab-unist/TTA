// Source Code
function sortThird(arr) {
    arr = arr.slice();
    for (let i = 0; i < arr.length; i += 3) {
        let tempArr = [];
        for (let j = i; j < Math.min(i + 3, arr.length); j++) {
            tempArr.push(arr[j]);
        }
        tempArr.sort((a, b) => a - b);
        for (let j = i, k = 0; j < Math.min(i + 3, arr.length); j++, k++) {
            arr[j] = tempArr[k];
        }
    }
    return arr;
}

// Transformed Code (Semantically Equivalent)
function sortThirdTransformed(l) {
    let resultList = [...l];
    for (let i = 0; i < resultList.length; i += 3) {
        let tempArr = resultList.slice(i, i + 3);
        tempArr.sort((a, b) => a - b);
        for (let j = 0; j < tempArr.length; j++) {
            resultList[i + j] = tempArr[j];
        }
    }
    return resultList;
}

// Test Cases
describe('sortThird vs sortThirdTransformed equivalence tests', () => {
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
        expect(sortThird(inputArray)).toEqual(sortThirdTransformed(inputArray))
    });
});