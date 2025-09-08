function evaluateExpression(operators, values) {
    let resultString = String(values[0]);
    let index = 0;
    while (index < operators.length) {
        resultString += operators[index] + String(values[index + 1]);
        index++;
    }
    return eval(resultString);
}

// method name: doAlgebra -> evaluateExpression
// parameter name: operator -> operators, operand -> values
// changed for loop to while loop
// used index variable to iterate through operators and values
// kept the logic of constructing the expression string and evaluating it