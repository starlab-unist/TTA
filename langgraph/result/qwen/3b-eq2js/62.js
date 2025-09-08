function computeDerivative(coefficients) {
    let result = [];
    let index = 1;
    while (index < coefficients.length) {
        result.push(index * coefficients[index]);
        index++;
    }
    return result;
}