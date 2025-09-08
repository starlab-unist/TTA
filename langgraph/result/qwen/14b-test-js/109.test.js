// Source Code
function moveOneBall(arr) {
    if (arr.length === 0) {
        return true;
    }
    const sortedArray = [...arr].sort((a, b) => a - b);
    let myArr = [];
    
    const minValue = Math.min(...arr);
    const minIndex = arr.indexOf(minValue);
    myArr = arr.slice(minIndex).concat(arr.slice(0, minIndex));
    for (let i = 0; i < arr.length; i++) {
        if (myArr[i] !== sortedArray[i]) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function checkSortedAfterRotation(sequence) {
    if (!sequence) {
        return true;
    }

    const orderedSequence = [...sequence].sort((a, b) => a - b);
    const smallestElement = Math.min(...sequence);
    const pivotIndex = sequence.indexOf(smallestElement);

    const rotatedSequence = sequence.slice(pivotIndex).concat(sequence.slice(0, pivotIndex));

    for (let idx = 0; idx < sequence.length; idx++) {
        if (rotatedSequence[idx] !== orderedSequence[idx]) {
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