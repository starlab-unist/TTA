// Source Code
function startsOneEnds(n) {
    if (n === 1) return 1;
    return 18 * Math.pow(10, n - 2);
}

// Transformed Code (Semantically Equivalent)
function calculateSpecialNumber(n) {
    if (n === 1) {
        return 1;
    }
    const multiplier = 18;
    const base = Math.pow(10, n - 2);
    return multiplier * base;
}

// Test Cases
describe('startsOneEnds vs calculateSpecialNumber equivalence tests', () => {
    const testCases = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

    test.each(testCases)('Input: %i', (inputValue) => {
        expect(startsOneEnds(inputValue)).toBe(calculateSpecialNumber(inputValue));
    });
});