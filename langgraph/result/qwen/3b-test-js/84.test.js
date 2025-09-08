// Source Code
function solve(N) {
    return (N.toString(2)).split('0').join('').length;
}

// Transformed Code (Not semantically equivalent)
function convertToBinaryString(number) {
    const digitSum = Array.from(String(number), digit => parseInt(digit, 10)).reduce((acc, digit) => acc + digit, 0);
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

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(solve(inputNumber)).toBe(convertToBinaryString(inputNumber).length);
    });
});