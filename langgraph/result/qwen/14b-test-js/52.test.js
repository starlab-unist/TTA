// Source Code
function belowThreshold(arr, threshold) {
    for (let e of arr) {
        if (e >= threshold) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function allElementsUnderLimit(elements, threshold) {
    let index = 0;
    while (index < elements.length) {
        if (elements[index] >= threshold) {
            return false;
        }
        index += 1;
    }
    return true;
}

// Test Cases
describe('belowThreshold vs allElementsUnderLimit equivalence tests', () => {
    const testCases = [
        [[], 10],                     // Empty list
        [[1, 2, 3, 4], 5],           // All elements below threshold
        [[10, 20, 30], 10],          // First element equals threshold
        [[5, 6, 7, 8], 5],           // First element equals threshold
        [[1, 2, 3, 4, 10], 5],       // One element above threshold
        [[9, 8, 7, 6, 5], 10],       // All elements below threshold
        [[10, 9, 8, 7, 6], 10],      // First element equals threshold
        [[1, 2, 3, 4, 5], 1],        // Threshold less than all elements
        [[0, -1, -2, -3], 0],        // Negative numbers below threshold
        [[-1, -2, -3, 0], 0]         // Negative numbers below threshold with zero
    ];

    test.each(testCases)('Input: array=%s, threshold=%d', (arr, threshold) => {
        expect(belowThreshold(arr, threshold)).toBe(allElementsUnderLimit(arr, threshold));
    });
});