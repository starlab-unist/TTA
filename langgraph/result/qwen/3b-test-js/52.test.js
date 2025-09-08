// Source Code
function belowThreshold(l, t) {
    for (let e of l) {
        if (e >= t) {
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
        index++;
    }
    return true;
}

// Test Cases
describe('belowThreshold vs allElementsUnderLimit equivalence tests', () => {
    const testCases = [
        { input: [[], 10], expected: true },                     // Empty list
        { input: [[1, 2, 3, 4], 5], expected: true },           // All elements below threshold
        { input: [[10, 20, 30], 10], expected: false },          // First element equals threshold
        { input: [[5, 6, 7, 8], 5], expected: false },           // First element equals threshold
        { input: [[1, 2, 3, 4, 10], 5], expected: false },       // One element above threshold
        { input: [[9, 8, 7, 6, 5], 10], expected: true },       // All elements below threshold
        { input: [[10, 9, 8, 7, 6], 10], expected: false },      // First element equals threshold
        { input: [[1, 2, 3, 4, 5], 1], expected: false },        // Threshold less than all elements
        { input: [[0, -1, -2, -3], 0], expected: true },        // Negative numbers below threshold
        { input: [[-1, -2, -3, 0], 0], expected: false }         // Negative numbers below threshold with zero
    ];

    test.each(testCases)('belowThreshold(%p, %p) should be equal to allElementsUnderLimit(%p, %p)', ({ input }, _, { input: [elements, threshold] }) => {
        expect(belowThreshold(input[0], input[1])).toBe(allElementsUnderLimit(elements, threshold));
    });
});