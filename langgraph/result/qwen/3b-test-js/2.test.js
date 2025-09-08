// Source Code
function truncateNumber(number) {
    return number % 1;
}

// Transformed Code (Semantically Equivalent)
function extractDecimalPart(value) {
    const decimalPart = value - Math.floor(value);
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

    test.each(testCases)('Input: %s', (inputValue) => {
        expect(truncateNumber(inputValue)).toBe(extractDecimalPart(inputValue));
    });
});