// Source Code
const math = require('mathjs');

function poly(xs, x) {
    /**
     * Evaluates polynomial with coefficients xs at point x.
     * return xs[0] + xs[1] * x + xs[1] * x^2 + .... xs[n] * x^n
     */
    return xs.reduce((acc, coeff, i) => acc + coeff * math.pow(x, i), 0);
}

function findZero(xs) {
    let begin = -1.0, end = 1.0;
    while (poly(xs, begin) * poly(xs, end) > 0) {
        begin *= 2.0;
        end *= 2.0;
    }
    while (end - begin > 1e-10) {
        const center = (begin + end) / 2.0;
        if (poly(xs, center) * poly(xs, begin) > 0) {
            begin = center;
        } else {
            end = center;
        }
    }
    return begin;
}

// Transformed Code
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

// Test Cases
const testCases = [
    ([1], 2.0),
    ([1, -3, 2], 2.0),  // x^2 - 3x + 2 = (x-1)(x-2)
    ([1, 0, -4], 2.0),  // x^2 - 4 = (x-2)(x+2)
    ([2, -4, 2], 1.0),  // 2x^2 - 4x + 2 = 2(x-1)^2
    ([1, -6, 11, -6], 3.0),  // x^3 - 6x^2 + 11x - 6 = (x-1)(x-2)(x-3)
    ([1, -3, 3, -1], 1.0),  // x^3 - 3x^2 + 3x - 1 = (x-1)^3
    ([1, 0, 0, 0, -1], 1.0),  // x^4 - 1 = (x-1)(x+1)(x^2+1)
    ([1, -5, 10, -10, 5, -1], 1.0),  // x^5 - 5x^4 + 10x^3 - 10x^2 + 5x - 1 = (x-1)^5
    ([0, 1], 0.0),  // x
    ([0, 0, 1], 0.0)  // x^2
];

describe('Function Equivalence Tests', () => {
    test.each(testCases)('poly and evaluatePolynomial should be approximately equal for coefficients %p at point %f', (coefficients, point) => {
        expect(poly(coefficients, point)).toBeCloseTo(evaluatePolynomial(coefficients, point), 9);
    });

    test.each(testCases.map(([coefficients]) => [coefficients]))('findZero and locateRoot should be approximately equal for coefficients %p', (coefficients) => {
        const root1 = findZero(coefficients);
        const root2 = locateRoot(coefficients);
        expect(root1).toBeCloseTo(root2, 5);
    });
});