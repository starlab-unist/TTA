// Source Code
function evenOddCount(num) {
    let evenCount = 0;
    let oddCount = 0;
    const absNumStr = Math.abs(num).toString();
    
    for (let char of absNumStr) {
        const digit = parseInt(char);
        if (digit % 2 === 0) {
            evenCount++;
        } else {
            oddCount++;
        }
    }
    
    return [evenCount, oddCount];
}

console.log(evenOddCount(12345)); // Example usage

// Transformed Code (Semantically Equivalent)
function tallyEvenOddDigits(number) {
    let evenTally = 0;
    let oddTally = 0;
    let index = 0;
    const numStr = Math.abs(number).toString();
    
    while (index < numStr.length) {
        const digit = parseInt(numStr[index], 10);
        if (digit % 2 === 0) {
            evenTally++;
        } else {
            oddTally++;
        }
        index++;
    }
    
    return [evenTally, oddTally];
}

// Test Cases
describe('evenOddCount vs tallyEvenOddDigits equivalence tests', () => {
    const testCases = [
        1234567890,
        -1234567890,
        24680,
        13579,
        0,
        111222333444,
        987654321,
        -987654321,
        1000000,
        1
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(evenOddCount(inputNumber)).toBe(tallyEvenOddDigits(inputNumber));
    });
});