// Source Code
function factorize(n) {
    const fact = [];
    let i = 2;
    while (i <= Math.sqrt(n) + 1) {
        if (n % i === 0) {
            fact.push(i);
            n /= i;
        } else {
            i += 1;
        }
    }

    if (n > 1) {
        fact.push(n);
    }
    return fact;
}

// Transformed Code (Semantically Equivalent)
function decomposeNumber(number) {
    const factors = [];
    let divisor = 2;
    while (divisor <= Math.floor(Math.sqrt(number))) {
        if (number % divisor === 0) {
            factors.push(divisor);
            number /= divisor;
        } else {
            divisor += 1;
        }
    }

    if (number > 1) {
        factors.push(number);
    }
    return factors;
}

// Test Cases
describe('factorize vs decomposeNumber equivalence tests', () => {
    const testCases = [
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        15
    ];

    test.each(testCases)('Input: %s', (inputNumber) => {
        expect(factorize(inputNumber)).toEqual(decomposeNumber(inputNumber));
    });
});