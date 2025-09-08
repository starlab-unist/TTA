// Source Code
function maxElement(arr) {
    let m = arr[0];
    for (let e of arr) {
        if (e > m) {
            m = e;
        }
    }
    return m;
}

// Transformed Code (Semantically Equivalent)
function findMaximumValue(l) {
    let m = l[0];
    let index = 1;
    while (index < l.length) {
        if (l[index] > m) {
            m = l[index];
        }
        index += 1;
    }
    return m;
}

// Test Cases
describe('maxElement vs findMaximumValue equivalence tests', () => {
    const testCases = [
        [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5],
        [-7, -1, -5, -3, -9],
        [10, 20, 30, 40, 50],
        [100],
        [0, 0, 0, 0],
        [5, 5, 5, 5, 6],
        [-1, -2, -3, -4, -5, -6],
        [1],
        [2, 2, 2, 1, 1, 1],
        [9, 8, 7, 6, 5, 4, 3, 2, 1]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(maxElement(inputArray)).toBe(findMaximumValue(inputArray));
    });
});