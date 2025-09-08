const math = require('mathjs');

function evaluatePolynomial(coefficients, value) {
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
        const midpoint = (lowerBound + upperBound) / 2.0;
        if (evaluatePolynomial(polynomialCoeffs, midpoint) * evaluatePolynomial(polynomialCoeffs, lowerBound) > 0) {
            lowerBound = midpoint;
        } else {
            upperBound = midpoint;
        }
    }
    
    return lowerBound;
}

// method name: poly -> evaluatePolynomial
// method name: find_zero -> locateRoot
// parameter name: xs -> coefficients, x -> value
// parameter name: xs -> polynomialCoeffs
// variable name: begin -> lowerBound, end -> upperBound
// variable name: center -> midpoint
// replaced list comprehension with for loop in evaluatePolynomial
// kept the same logic and structure for locating the root