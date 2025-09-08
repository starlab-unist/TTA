// Source Code
function largestDivisor(n) {
    for (let i = n - 1; i > 0; i--) {
        if (n % i === 0) {
            return i;
        }
    }
}

// Transformed Code (Semantically Equivalent)
function findGreatestDivisor(number) {
    let divisor = number - 1;
    while (divisor > 0) {
        if (number % divisor === 0) {
            return divisor;
        }
        divisor--;
    }
}

// Test Cases
describe('largestDivisor vs findGreatestDivisor equivalence tests', () => {
    const testCases = [
        [1, null],       // Edge case: no divisors for 1 (original function will raise an error)
        [2, 1],
        [3, 1],
        [4, 2],
        [5, 1],
        [6, 3],
        [10, 5],
        [15, 5],
        [20, 10],
        [25, 5]
    ];

    test.each(testCases)('Input: %i', (inputNumber, expectedOutput) => {
        if (inputNumber === 1) {
            // Special case for input 1 where the original function returns `undefined` instead of raising an error
            expect(largestDivisor(inputNumber)).toBeUndefined();
        } else {
            expect(largestDivisor(inputNumber)).toBe(expectedOutput);
        }
        expect(findGreatestDivisor(inputNumber)).toBe(expectedOutput);
    });
});