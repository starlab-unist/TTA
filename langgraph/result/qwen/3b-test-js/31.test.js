// Source Code
function original_isPrime(n) {
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

// Transformed Code
function transformed_isPrime(n) {
    if (n < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < n - 1) {
        if (n % divisor === 0) {
            return false;
        }
        divisor++;
    }
    return true;
}

// Test Cases
describe('original_isPrime vs transformed_isPrime equivalence tests', () => {
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

    test.each(testCases)('Input: %s', (inputNumber) => {
        expect(original_isPrime(inputNumber)).toBe(transformed_isPrime(inputNumber));
    });
});