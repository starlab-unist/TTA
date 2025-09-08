// Source Code
function isEqualToSumEven(n) {
    return n % 2 === 0 && n >= 8;
}

// Transformed Code (Semantically Equivalent)
function checkEvenAndMinimumEight(number) {
    return number % 2 === 0 && number >= 8;
}

// Test Cases
describe('isEqualToSumEven vs checkEvenAndMinimumEight equivalence tests', () => {
    const testCases = [
        [4, false],
        [6, false],
        [8, true],
        [10, true],
        [12, true],
        [7, false],
        [9, false],
        [0, false],
        [-2, false],
        [8.0, true],  // Edge case: float that is an integer
        [10.5, false]  // Edge case: non-integer float
    ];

    test.each(testCases)('Input: %s', (inputNumber, expectedOutput) => {
        expect(isEqualToSumEven(inputNumber)).toBe(checkEvenAndMinimumEight(inputNumber));
    });
});