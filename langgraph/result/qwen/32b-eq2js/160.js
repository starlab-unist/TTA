function evaluateExpression(operators, values) {
    let resultString = String(values[0]);
    let index = 0;
    while (index < operators.length) {
        resultString += operators[index] + String(values[index + 1]);
        index += 1;
    }
    return eval(resultString);
}