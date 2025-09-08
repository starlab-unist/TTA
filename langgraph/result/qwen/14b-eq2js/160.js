function evaluateExpression(operators, values) {
    let resultString = values[0].toString();
    let index = 0;
    while (index < operators.length) {
        resultString += operators[index] + values[index + 1].toString();
        index += 1;
    }
    return eval(resultString);
}