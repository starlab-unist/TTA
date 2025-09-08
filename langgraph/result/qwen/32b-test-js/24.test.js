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
        divisor -= 1;
    }
}

// Test Cases
describe('largestDivisor vs findGreatestDivisor equivalence tests', () => {
    const testCases = [
        { input: 1, expected: null },       // Edge case: no divisors for 1 (original function will return undefined)
        { input: 2, expected: 1 },
        { input: 3, expected: 1 },
        { input: 4, expected: 2 },
        { input: 5, expected: 1 },
        { input: 6, expected: 3 },
        { input: 10, expected: 5 },
        { input: 15, expected: 5 },
        { input: 20, expected: 10 },
        { input: 25, expected: 5 }
    ];

    test.each(testCases)('Input: $input', ({ input, expected }) => {
        expect(largestDivisor(input)).toBe(expected);
        expect(findGreatestDivisor(input)).toBe(expected);
    });

    // Edge case specific test for n = 1
    test('Edge case Input: 1 (largestDivisor should return undefined)', () => {
        expect(largestDivisor(1)).toBe(undefined); // largestDivisor returns undefined, not null
    });
});