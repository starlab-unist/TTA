// Source Code
function stringSequence(n) {
    return Array.from({ length: n + 1 }, (_, i) => i).join(' ');
}

// Transformed Code (Semantically Equivalent)
function generateNumberSeries(length) {
    const numberList = [];
    let index = 0;

    while (index <= length) {
        numberList.push(String(index));
        index += 1;
    }

    const series = numberList.join(' ');
    return series;
}

// Test Cases
describe('stringSequence vs generateNumberSeries equivalence tests', () => {
    const testCases = [
        0,
        1,
        5,
        10,
        20,
        100,
        -1,  // Edge case: negative input
        3,
        7,
        15
    ];

    test.each(testCases)('Input: %i', (inputNumber) => {
        expect(stringSequence(inputNumber)).toBe(generateNumberSeries(inputNumber));
    });
});