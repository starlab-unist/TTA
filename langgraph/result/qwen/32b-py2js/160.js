function doAlgebra(operator, operand) {
    let expression = String(operand[0]);
    for (let i = 0; i < operator.length; i++) {
        expression += operator[i] + String(operand[i + 1]);
    }
    return eval(expression);
}