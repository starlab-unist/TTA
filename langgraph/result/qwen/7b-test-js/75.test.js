// Source Code
function isMultiplyPrime(a) {
    function isPrime(n) {
        for (let j = 2; j < n; j++) {
            if (n % j === 0) {
                return false;
            }
        }
        return true;
    }

    for (let i = 2; i <= 100; i++) {
        if (!isPrime(i)) continue;
        for (let j = 2; j <= 100; j++) {
            if (!isPrime(j)) continue;
            for (let k = 2; k <= 100; k++) {
                if (!isPrime(k)) continue;
                if (i * j * k === a) return true;
            }
        }
    }
    return false;
}

// Transformed Code (Semantically Equivalent)
function checkProductOfThreePrimes(a) {
    function isPrime(value) {
        for (let divisor = 2; divisor < value; divisor++) {
            if (value % divisor === 0) {
                return false;
            }
        }
        return true;
    }

    const primeRange = Array.from({ length: 100 }, (_, i) => i + 2);
    for (const first of primeRange) {
        if (!isPrime(first)) continue;
        for (const second of primeRange) {
            if (!isPrime(second)) continue;
            for (const third of primeRange) {
                if (!isPrime(third)) continue;
                if (first * second * third === a) {
                    return true;
                }
            }
        }
    }
    return false;
}

// Test Cases
describe('isMultiplyPrime vs checkProductOfThreePrimes equivalence tests', () => {
    const testCases = [
        30,   // 2*3*5
        60,   // 2*2*3*5 (False)
        105,  // 3*5*7
        231,  // 3*7*11
        385,  // 5*7*11
        500,  // 2*2*5*5*5 (False)
        770,  // 2*5*7*11 (False)
        969,  // 3*11*29
        1001, # 7*11*13
        1385  // 5*11*25 (False)
    ];

    testCases.forEach((testCase, index) => {
        it(`Test case ${index}`, () => {
            expect(isMultiplyPrime(testCase)).toBe(checkProductOfThreePrimes(testCase));
        });
    });
});