// Source Code
function compareOne(a, b) {
    let tempA = a;
    let tempB = b;
    if (typeof tempA === 'string') tempA = tempA.replace(',', '.');
    if (typeof tempB === 'string') tempB = tempB.replace(',', '.');
    const numA = parseFloat(tempA);
    const numB = parseFloat(tempB);
    if (numA === numB) return null;
    return numA > numB ? a : b;
}

// Transformed Code (Semantically Equivalent)
function evaluateAndCompare(a, b) {
    let tempA = a;
    let tempB = b;

    if (typeof tempA === 'string') {
        tempA = tempA.replace(',', '.');
    }
    if (typeof tempB === 'string') {
        tempB = tempB.replace(',', '.');
    }

    const numericVal1 = parseFloat(tempA);
    const numericVal2 = parseFloat(tempB);

    if (numericVal1 === numericVal2) {
        return null;
    } else if (numericVal1 > numericVal2) {
        return a;
    } else {
        return b;
    }
}

// Test Cases
describe('compareOne vs evaluateAndCompare equivalence tests', () => {
    const testCases = [
        [5, 3],
        ["4.5", "4.6"],
        ["7,8", "7.8"],
        ["10", 10],
        ["123", "123.0"],
        ["1,234", "1.234"],
        ["9.99", 9.990],
        ["5", "5"],
        ["6", 6],
        ["7.5", "7,5"]
    ];

    test.each(testCases)('Input: %s, %s', (inputA, inputB) => {
        expect(compareOne(inputA, inputB)).toBe(evaluateAndCompare(inputA, inputB));
    });
});