// Source Code
function isPrime(n) {
    if (n < 2) {
        return false;
    }
    for (let k = 2; k < n - 1; k++) {
        if (n % k === 0) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function checkPrime(number) {
    if (number < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < number - 1) {
        if (number % divisor === 0) {
            return false;
        }
        divisor += 1;
    }
    return true;
}

// Test Cases
describe('isPrime vs checkPrime equivalence tests', () => {
    const testCases = [
        0,      // Not prime (less than 2)
        1,      // Not prime (less than 2)
        2,      // Prime
        3,      // Prime
        4,      // Not prime
        5,      // Prime
        9,      // Not prime
        11,     // Prime
        16,     // Not prime
        17,     // Prime
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(isPrime(inputNumber)).toBe(checkPrime(inputNumber));
    });
});