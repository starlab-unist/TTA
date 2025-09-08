function computeDerivative(coefficients) {
    const result = [];
    let index = 1;
    while (index < coefficients.length) {
        result.push(index * coefficients[index]);
        index += 1;
    }
    return result;
}