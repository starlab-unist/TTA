// Source Code
function moveOneBall(arr) {
    if (arr.length === 0) {
        return true;
    }
    let sortedArray = [...arr].sort((a, b) => a - b);
    let myArr = [];
    
    let minValue = Math.min(...arr);
    let minIndex = arr.indexOf(minValue);
    myArr = [...arr.slice(minIndex), ...arr.slice(0, minIndex)];
    for (let i = 0; i < arr.length; i++) {
        if (myArr[i] !== sortedArray[i]) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function checkSortedAfterRotation(arr) {
    if (!arr.length) {
        return true;
    }

    const orderedArray = [...arr].sort((a, b) => a - b);
    const smallestElement = Math.min(...arr);
    const pivotIndex = arr.indexOf(smallestElement);

    const rotatedArray = arr.slice(pivotIndex).concat(arr.slice(0, pivotIndex));

    for (let idx = 0; idx < arr.length; idx++) {
        if (rotatedArray[idx] !== orderedArray[idx]) {
            return false;
        }
    }

    return true;
}

// Test Cases
describe('moveOneBall vs checkSortedAfterRotation equivalence tests', () => {
    const testCases = [
        [],
        [1],
        [2, 1],
        [3, 2, 1],
        [1, 2, 3],
        [4, 5, 6, 1, 2, 3],
        [2, 3, 4, 5, 6, 1],
        [1, 3, 2],
        [5, 1, 2, 3, 4],
        [10, 20, 30, 40, 50]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(moveOneBall(inputArray)).toBe(checkSortedAfterRotation(inputArray));
    });
});