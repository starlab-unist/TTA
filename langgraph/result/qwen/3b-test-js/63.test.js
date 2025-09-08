// Source Code
function fibfib(n) {
    if (n === 0) return 0;
    if (n === 1) return 0;
    if (n === 2) return 1;
    return fibfib(n - 1) + fibfib(n - 2) + fibfib(n - 3);
}

// Transformed Code (Semantically Equivalent)
function calculateModifiedFibonacci(index) {
    if (index === 0) {
        return 0;
    } else if (index === 1) {
        return 0;
    } else if (index === 2) {
        return 1;
    } else {
        return (
            calculateModifiedFibonacci(index - 1) +
            calculateModifiedFibonacci(index - 2) +
            calculateModifiedFibonacci(index - 3)
        );
    }
}

// Test Cases
describe('fibfib vs calculateModifiedFibonacci equivalence tests', () => {
    const testCases = [
        0,  // Base case
        1,  // Base case
        2,  // Base case
        3,  // Simple case
        4,  // Slightly larger input
        5,  // Further recursion
        6,  // Further recursion
        7,  // Further recursion
        8,  // Further recursion
        9   // Larger input to test deeper recursion
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(fibfib(inputNumber)).toBe(calculateModifiedFibonacci(inputNumber));
    });
});