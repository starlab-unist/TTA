// Source Code
function doAlgebra(operator, operand) {
    let expression = String(operand[0]);
    for (let i = 0; i < operator.length; i++) {
        expression += operator[i] + String(operand[i + 1]);
    }
    return eval(expression);
}

// Transformed Code (Semantically Equivalent)
function evaluateExpression(operators, values) {
    let resultString = String(values[0]);
    let index = 0;
    while (index < operators.length) {
        resultString += operators[index] + String(values[index + 1]);
        index += 1;
    }
    return eval(resultString);
}

// Test Cases
describe('doAlgebra vs evaluateExpression equivalence tests', () => {
    const testCases = [
        [['+', '*', '-'], [2, 3, 4, 5]],  // (2 + 3) * 4 - 5 = 9
        [['-', '/'], [10, 5, 2]],         // 10 - 5 / 2 = 7.5
        [['*', '+', '/'], [1, 2, 3, 4]],   // (1 * 2) + 3 / 4 = 2.75
        [['+', '-', '*', '/'], [0, 1, 1, 1, 1]],  // (0 + 1) - 1 * 1 / 1 = 0.0
        [['**', '+'], [2, 3, 4]],          // 2 ** 3 + 4 = 12
        [['+', '-', '+'], [1, 1, 1, 1]],   // 1 + 1 - 1 + 1 = 2
        [['*', '*', '*'], [2, 2, 2, 2]],   // 2 * 2 * 2 * 2 = 16
        [['/', '+', '-'], [8, 4, 2, 1]],   // 8 / 4 + 2 - 1 = 3.0
        [['+', '-', '*', '/'], [0, 1, 1, 1, 1]],  // (0 + 1) - 1 * 1 / 1 = 0.0
        [['**', '*', '+'], [2, 3, 4, 5]],   // (2 ** 3) * 4 + 5 = 37
    ];

    testCases.forEach(([operators, values], index) => {
        test(`Test case ${index}`, () => {
            expect(doAlgebra(operators, values)).toBeCloseTo(evaluateExpression(operators, values), 5);
        });
    });
});