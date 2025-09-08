// Source Code
function truncateNumber(number) {
    return number % 1.0;
}

// Transformed Code (Semantically Equivalent)
function extractDecimalPart(number) {
    const decimalPart = number - Math.floor(number);
    return decimalPart;
}

// Test Cases
describe('truncateNumber vs extractDecimalPart equivalence tests', () => {
    const testCases = [
        3.14159,
        0.99999,
        123.456,
        -789.123,
        0.0,
        -0.0,
        100.0,
        -100.0,
        1.0,
        -1.0
    ];

    test.each(testCases)('Input: %f', (inputNumber) => {
        expect(truncateNumber(inputNumber)).toBe(extractDecimalPart(inputNumber));
    });
});