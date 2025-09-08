// Source Code
function largestPrimeFactor(n) {
    function isPrime(k) {
        if (k < 2) {
            return false;
        }
        for (let i = 2; i <= Math.sqrt(k); i++) {
            if (k % i === 0) {
                return false;
            }
        }
        return true;
    }
    let largest = 1;
    for (let j = 2; j <= n; j++) {
        if (n % j === 0 && isPrime(j)) {
            largest = Math.max(largest, j);
        }
    }
    return largest;
}

// Transformed Code (Semantically Equivalent)
function findMaxPrimeDivisor(number) {
    function checkPrime(candidate) {
        if (candidate < 2) {
            return false;
        }
        let factor = 2;
        while (factor * factor <= candidate) {
            if (candidate % factor === 0) {
                return false;
            }
            factor++;
        }
        return true;
    }
    let maxPrime = 1;
    let factor = 2;
    while (factor <= number) {
        if (number % factor === 0 && checkPrime(factor)) {
            maxPrime = Math.max(maxPrime, factor);
        }
        factor++;
    }
    return maxPrime;
}

// Test Cases
describe('Function Equivalence Tests', () => {
    const testCases = [
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20
    ];

    testCases.forEach((testCase, index) => {
        it(`Test Case ${index}`, () => {
            expect(largestPrimeFactor(testCase)).toBe(findMaxPrimeDivisor(testCase));
        });
    });
});