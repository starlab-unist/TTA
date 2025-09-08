// Source Code
function compareOne(a, b) {
    let tempA = a;
    let tempB = b;
    if (typeof tempA === 'string') tempA = tempA.replace(',', '.');
    if (typeof tempB === 'string') tempB = tempB.replace(',', '.');
    if (parseFloat(tempA) === parseFloat(tempB)) return null;
    return parseFloat(tempA) > parseFloat(tempB) ? a : b;
}

// Transformed Code (Semantically Equivalent)
function evaluateAndCompare(value1, value2) {
    let modifiedVal1 = value1;
    let modifiedVal2 = value2;
    if (typeof modifiedVal1 === 'string') {
        modifiedVal1 = modifiedVal1.replace(',', '.');
    }
    if (typeof modifiedVal2 === 'string') {
        modifiedVal2 = modifiedVal2.replace(',', '.');
    }

    const numericVal1 = parseFloat(modifiedVal1);
    const numericVal2 = parseFloat(modifiedVal2);
    if (numericVal1 === numericVal2) {
        return null;
    } else if (numericVal1 > numericVal2) {
        return value1;
    } else {
        return value2;
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
        expect(compareOne(inputA, inputB)).toBe(evaluateAndCompare(inputA, inputB))
    });
});