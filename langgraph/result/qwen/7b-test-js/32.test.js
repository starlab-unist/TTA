// Source Code
function poly(xs, x) {
    return xs.reduce((sum, coeff, i) => sum + coeff * Math.pow(x, i), 0);
}

function findZero(xs) {
    let begin = -1.0;
    let end = 1.0;
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

// Transformed Code (Semantically Equivalent)
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

// Jest test cases for poly and evaluatePolynomial
testCases.forEach(([coefficients, point]) => {
    test(`poly and evaluatePolynomial with coefficients ${coefficients} and point ${point}`, () => {
        expect(poly(coefficients, point)).toBeCloseTo(evaluatePolynomial(coefficients, point), 9);
    });
});

// Jest test cases for findZero and locateRoot
testCases.forEach(([coefficients]) => {
    test(`findZero and locateRoot with coefficients ${coefficients}`, () => {
        const root1 = findZero(coefficients);
        const root2 = locateRoot(coefficients);
        expect(root1).toBeCloseTo(root2, 5);
    });
});