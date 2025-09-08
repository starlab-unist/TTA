// Source Code
function monotonic(arr) {
    const sortedArr = [...arr].sort((a, b) => a - b);
    const reversedArr = [...arr].sort((a, b) => b - a);
    return JSON.stringify(arr) === JSON.stringify(sortedArr) || JSON.stringify(arr) === JSON.stringify(reversedArr);
}

// Transformed Code (Semantically Equivalent)
function checkMonotonicSequence(sequence) {
    const ascending = [...sequence];
    const descending = [...sequence];
    
    ascending.sort((a, b) => a - b);
    descending.sort((a, b) => b - a);
    
    if (JSON.stringify(sequence) === JSON.stringify(ascending) || JSON.stringify(sequence) === JSON.stringify(descending)) {
        return true;
    }
    return false;
}

// Test Cases
describe('monotonic vs checkMonotonicSequence equivalence tests', () => {
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

    test.each(testCases)('Input: "%s"', (inputArray) => {
        expect(monotonic(inputArray)).toBe(checkMonotonicSequence(inputArray));
    });
});