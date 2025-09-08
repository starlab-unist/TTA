// Source Code
function isMonotonic(arr) {
    const sortedArr = [...arr].sort((a, b) => a - b);
    const reversedArr = [...arr].sort((a, b) => b - a);

    return arr.every((value, index) => value === sortedArr[index]) ||
           arr.every((value, index) => value === reversedArr[index]);
}

// Transformed Code (Semantically Equivalent)
function checkMonotonicSequence(sequence) {
    const ascending = [...sequence];
    const descending = [...sequence];
    
    ascending.sort((a, b) => a - b);
    descending.sort((a, b) => b - a);
    
    if (arraysEqual(sequence, ascending) || arraysEqual(sequence, descending)) {
        return true;
    }
    return false;
}

function arraysEqual(arr1, arr2) {
    if (arr1.length !== arr2.length) return false;
    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] !== arr2[i]) return false;
    }
    return true;
}

// Test Cases
describe('isMonotonic vs checkMonotonicSequence equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5],       // strictly increasing
        [5, 4, 3, 2, 1],       // strictly decreasing
        [1, 1, 1, 1, 1],       // all elements are the same
        [1, 2, 2, 3, 4],       // non-decreasing
        [5, 5, 4, 4, 3, 2, 1], // non-increasing
        [1, 3, 2],             // not monotonic
        [],                    // empty list
        [10],                  // single element
        [3, 3, 2, 1, 1, 1],    // decreasing with duplicates
        [1, 1, 2, 2, 3, 3]     // increasing with duplicates
    ];

    test.each(testCases)('Input: %j', (inputArray) => {
        expect(isMonotonic(inputArray)).toBe(checkMonotonicSequence(inputArray));
    });
});