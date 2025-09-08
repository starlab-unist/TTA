function evaluatePolynomial(coefficients, value) {
    /**
     * Calculates the value of a polynomial with given coefficients at a specific point.
     * The polynomial is defined as: coefficients[0] + coefficients[1] * value + coefficients[2] * value^2 + ... + coefficients[n] * value^n
     */
    let result = 0.0;
    for (let index = 0; index < coefficients.length; index++) {
        result += coefficients[index] * Math.pow(value, index);
    }
    return result;
}

function locateRoot(polynomialCoeffs) {
    let lowerBound = -1.0, upperBound = 1.0;
    while (evaluatePolynomial(polynomialCoeffs, lowerBound) * evaluatePolynomial(polynomialCoeffs, upperBound) > 0) {
        lowerBound *= 2.0;
        upperBound *= 2.0;
    }
    
    while (upperBound - lowerBound > 1e-10) {
        let midpoint = (lowerBound + upperBound) / 2.0;
        if (evaluatePolynomial(polynomialCoeffs, midpoint) * evaluatePolynomial(polynomialCoeffs, lowerBound) > 0) {
            lowerBound = midpoint;
        } else {
            upperBound = midpoint;
        }
    }
    
    return lowerBound;
}