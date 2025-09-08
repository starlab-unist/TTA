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

console.log(findGreatestDivisor(15)); // Example usage

// Test Cases
describe('largestDivisor vs findGreatestDivisor equivalence tests', () => {
    const testCases = [
        [1, null],       // Edge case: no divisors for 1 (original function will return undefined)
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

    test.each(testCases)('Input: %d', (inputNumber, expectedOutput) => {
        if (inputNumber === 1) {
            expect(largestDivisor(inputNumber)).toBeUndefined(); // Original function returns undefined for input 1
        } else {
            expect(largestDivisor(inputNumber)).toBe(expectedOutput);
        }
        expect(findGreatestDivisor(inputNumber)).toBe(expectedOutput);
    });
});