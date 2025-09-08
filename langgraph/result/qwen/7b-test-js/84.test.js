// Source Code
function solve(N) {
    return (N.toString().split('').reduce((acc, digit) => acc + parseInt(digit), 0)).toString(2);
}

// Transformed Code (Semantically Equivalent)
function convertToBinaryString(number) {
    let digitSum = number.toString().split('').reduce((sum, digit) => sum + parseInt(digit, 10), 0);
    let binaryRepresentation = digitSum.toString(2);
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
        expect(solve(inputNumber)).toBe(convertToBinaryString(inputNumber));
    });
});