// Source Code
function doAlgebra(operator, operand) {
    let expression = operand[0].toString();
    for (let i = 0; i < operator.length; i++) {
        expression += operator[i] + operand[i + 1].toString();
    }
    return Function('"use strict";return (' + expression + ')')();
}

// Transformed Code (Semantically Equivalent)
function evaluateExpression(operators, values) {
    let resultString = values[0].toString();
    let index = 0;
    while (index < operators.length) {
        resultString += operators[index] + values[index + 1].toString();
        index += 1;
    }
    return eval(resultString);
}

// Test Cases
describe('doAlgebra vs evaluateExpression equivalence tests', () => {
    const testCases = [
        { operators: ['+', '*', '-'], operands: [2, 3, 4, 5] },  // (2 + 3) * 4 - 5 = 9
        { operators: ['-', '/'], operands: [10, 5, 2] },         // 10 - 5 / 2 = 7.5
        { operators: ['*', '+', '/'], operands: [1, 2, 2, 4] },   // 1 * 2 + 2 / 4 = 2.5
        { operators: ['+', '-', '*', '/'], operands: [10, 5, 3, 2, 4] },  // ((10 + 5) - 3) * 2 / 4 = 4.0
        { operators: ['**', '+'], operands: [2, 3, 4] },          // 2 ** 3 + 4 = 12
        { operators: ['+', '-', '+'], operands: [1, 1, 1, 1] },   // 1 + 1 - 1 + 1 = 2
        { operators: ['*', '*', '*'], operands: [2, 2, 2, 2] },   // 2 * 2 * 2 * 2 = 16
        { operators: ['/', '+', '-'], operands: [8, 4, 2, 1] },   // 8 / 4 + 2 - 1 = 3.0
        { operators: ['+', '-', '*', '/'], operands: [0, 1, 1, 1, 1] },  // (0 + 1) - 1 * 1 / 1 = 0.0
        { operators: ['**', '*', '+'], operands: [2, 3, 4, 5] },   // (2 ** 3) * 4 + 5 = 37
    ];

    testCases.forEach(({ operators, operands }, index) => {
        it(`test_${index}`, () => {
            expect(doAlgebra(operators, operands)).toBe(evaluateExpression(operators, operands));
        });
    });
});