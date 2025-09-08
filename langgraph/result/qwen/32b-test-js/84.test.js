// Source Code
function solve(N) {
    return (N.toString().split('').reduce((sum, digit) => sum + parseInt(digit, 10), 0)).toString(2);
}

// Transformed Code (Semantically Equivalent)
function convertToBinaryString(number) {
    const digitSum = String(number).split('').reduce((sum, digit) => sum + parseInt(digit, 10), 0);
    const binaryRepresentation = digitSum.toString(2);
    return binaryRepresentation;
}

// Test Cases
describe('solve vs convertToBinaryString equivalence tests', () => {
    const testCases = [
        0,
        1,
        9,
        123,
        456,
        789,
        1001,
        11111111,
        987654321,
        Math.pow(2, 10)
    ];

    test.each(testCases)('Input: %s', (inputNumber) => {
        expect(solve(inputNumber)).toBe(convertToBinaryString(inputNumber))
    });
});