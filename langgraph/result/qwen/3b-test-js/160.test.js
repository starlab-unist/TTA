// Source Code
function doAlgebra(operator, operand) {
    let expression = operand[0].toString();
    for (let i = 0; i < operator.length; i++) {
        expression += operator[i] + operand[i + 1];
    }
    try {
        return eval(expression);
    } catch (error) {
        throw new Error("Invalid expression");
    }
}

// Transformed Code (Semantically Equivalent)
function evaluateExpression(operators, values) {
    let resultString = String(values[0]);
    let index = 0;
    while (index < operators.length) {
        resultString += operators[index] + String(values[index + 1]);
        index++;
    }
    return eval(resultString);
}

// Test Cases
describe('doAlgebra vs evaluateExpression equivalence tests', () => {
    const testCases = [
        { operators: ['+', '*', '-'], values: [2, 3, 4, 5] },  // (2 + 3) * 4 - 5 = 17
        { operators: ['+', '-', '*', '/'], values: [10, 5, 3, 2, 4] },  // ((10 + 5) - 3) * 2 / 4 = 4.0
        { operators: ['**', '+'], values: [2, 3, 4] },          // 2 ** 3 + 4 = 12
        { operators: ['+', '-', '+'], values: [1, 1, 1, 1] },   // 1 + 1 - 1 + 1 = 2
        { operators: ['*', '*', '*'], values: [2, 2, 2, 2] },   // 2 * 2 * 2 * 2 = 16
        { operators: ['/', '+', '-'], values: [8, 4, 2, 1] },   // 8 / 4 + 2 - 1 = 3.0
        { operators: ['+', '-', '*', '/'], values: [0, 1, 1, 1, 1] },  // (0 + 1) - 1 * 1 / 1 = 0.0
        { operators: ['**', '*', '+'], values: [2, 3, 4, 5] }   // (2 ** 3) * 4 + 5 = 37
    ];

    testCases.forEach(({ operators, values }, index) => {
        it(`Test case ${index}`, () => {
            expect(doAlgebra(operators, values)).toBe(evaluateExpression(operators, values));
        });
    });
});