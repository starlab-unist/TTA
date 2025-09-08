// Source Code
function canArrange(arr) {
    let ind = -1;
    let i = 1;
    while (i < arr.length) {
        if (arr[i] < arr[i - 1]) {
            ind = i;
        }
        i++;
    }
    return ind;
}

// Transformed Code (Semantically Equivalent)
function findFirstDecreaseIndex(arr) {
    let ind = -1; // Initialize index of the first decrease to -1
    let i = 1; // Start checking from the second element
    while (i < arr.length) {
        if (arr[i] < arr[i - 1]) {
            ind = i; // Update index to the current position
        }
        i++; // Move to the next element
    }
    return ind; // Return the index or -1 if no decrease is found
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