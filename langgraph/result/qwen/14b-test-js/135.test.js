// Source Code
function canArrange(arr) {
    let ind = -1;
    let i = 1;
    while (i < arr.length) {
        if (arr[i] < arr[i - 1]) {
            ind = i;
        }
        i += 1;
    }
    return ind;
}

// Transformed Code (Semantically Equivalent)
function findFirstDecreaseIndex(sequence) {
    let position = -1;
    let index = 1;
    while (index < sequence.length) {
        if (sequence[index] < sequence[index - 1]) {
            position = index;
        }
        index += 1;
    }
    return position;
}

// Test Cases
describe('canArrange vs findFirstDecreaseIndex equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5],
        [5, 4, 3, 2, 1],
        [1, 3, 2, 4, 5],
        [10, 20, 30, 25, 40],
        [1, 1, 1, 1, 1],
        [1, 2, 3, 3, 2],
        [1],
        [],
        [7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1],
        [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(canArrange(inputArray)).toBe(findFirstDecreaseIndex(inputArray));
    });
});