// Source Code
function evenOddCount(num) {
    let evenCount = 0;
    let oddCount = 0;
    for (let i of Math.abs(num).toString()) {
        if (parseInt(i) % 2 === 0) {
            evenCount += 1;
        } else {
            oddCount += 1;
        }
    }
    return [evenCount, oddCount];
}

// Transformed Code (Semantically Equivalent)
function tallyEvenOddDigits(number) {
    let evenTally = 0;
    let oddTally = 0;
    let index = 0;
    const numStr = Math.abs(number).toString();
    
    while (index < numStr.length) {
        const digit = parseInt(numStr[index], 10);
        if (digit % 2 === 0) {
            evenTally += 1;
        } else {
            oddTally += 1;
        }
        index += 1;
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

    test.each(testCases)('Input: %s', (inputNumber) => {
        expect(evenOddCount(inputNumber)).toEqual(tallyEvenOddDigits(inputNumber));
    });
});