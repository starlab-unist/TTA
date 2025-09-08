// Source Code
function decimalToBinary(decimal) {
    return "db" + decimal.toString(2) + "db";
}

// Transformed Code (Semantically Equivalent)
function convertDecimalToBinary(number) {
    const binaryRepresentation = number.toString(2);
    return `db${binaryRepresentation}db`;
}

// Test Cases
describe('decimalToBinary vs convertDecimalToBinary equivalence tests', () => {
    const testCases = [
        0,
        1,
        2,
        5,
        10,
        15,
        32,
        64,
        255,
        1023
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(decimalToBinary(inputNumber)).toBe(convertDecimalToBinary(inputNumber));
    });
});