// Source Code
function sumToN(n) {
    return (n * (n + 1)) / 2;
}

// Transformed Code (Semantically Equivalent)
function calculateTotalUpTo(number) {
    let totalSum = 0;
    let current = 0;
    
    while (current <= number) {
        totalSum += current;
        current += 1;
    }
    
    return totalSum;
}

// Test Cases
describe('sumToN vs calculateTotalUpTo equivalence tests', () => {
    const testCases = [
        0,      // Edge case: smallest possible input
        1,      // Simple case
        5,      // Small positive integer
        10,     // Medium positive integer
        20,     // Larger positive integer
        100,    // Large positive integer
        -1,     // Negative number (edge case)
        -5,     // Another negative number
        1000,   // Very large positive integer
        1       // Repeated simple case
    ];

    test.each(testCases)('Input: %i', (inputValue) => {
        expect(sumToN(inputValue)).toBe(calculateTotalUpTo(inputValue));
    });
});