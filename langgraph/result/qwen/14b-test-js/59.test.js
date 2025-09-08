// Source Code
function largestPrimeFactor(n) {
    function isPrime(k) {
        if (k < 2) {
            return false;
        }
        for (let i = 2; i < k - 1; i++) {
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
        let divisor = 2;
        while (divisor * divisor <= candidate) {
            if (candidate % divisor === 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }

    let largest = 1;
    for (let j = 2; j <= number; j++) {
        if (number % j === 0 && checkPrime(j)) {
            largest = Math.max(largest, j);
        }
    }
    return largest;
}

// Jest Test Cases
describe('largestPrimeFactor vs findMaxPrimeDivisor', () => {
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
        it(`should return the same result for input ${testCase}`, () => {
            expect(largestPrimeFactor(testCase)).toBe(findMaxPrimeDivisor(testCase));
        });
    });
});