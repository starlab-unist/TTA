// Source Code
function skjkasdkd(lst) {
    function isPrime(n) {
        for (let i = 2; i <= Math.sqrt(n); i++) {
            if (n % i === 0) {
                return false;
            }
        }
        return true;
    }

    let maxx = 0;
    let i = 0;
    while (i < lst.length) {
        if (lst[i] > maxx && isPrime(lst[i])) {
            maxx = lst[i];
        }
        i++;
    }

    const result = String(maxx).split('').reduce((sum, digit) => sum + parseInt(digit), 0);
    return result;
}

// Transformed Code (Semantically Equivalent)
function findLargestPrimeDigitSum(lst) {
    function checkPrime(number) {
        for (let divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor === 0) {
                return false;
            }
        }
        return true;
    }

    let largestPrime = 0;
    let index = 0;
    while (index < lst.length) {
        if (lst[index] > largestPrime && checkPrime(lst[index])) {
            largestPrime = lst[index];
        }
        index++;
    }

    const digitSum = [...largestPrime.toString()].reduce((sum, char) => sum + parseInt(char), 0);
    return digitSum;
}

// Test Cases
describe('skjkasdkd vs findLargestPrimeDigitSum equivalence tests', () => {
    const testCases = [
        [3, 5, 7, 2, 8],          // Simple list with primes
        [10, 15, 21, 22],         // No prime numbers
        [29, 31, 37, 41],         // All prime numbers
        [1, 4, 6, 8, 9],          // Only one prime (2)
        [0, -3, -5, -7],          // Negative and zero values
        [11, 13, 17, 19, 23, 29], // Larger primes
        [2, 3, 5, 7, 11, 13],     // Small consecutive primes
        [41, 37, 31, 29, 23],     // Descending order of primes
        [89, 97, 101, 103],       // Primes greater than 80
        [59, 61, 67, 71, 73]      // Another set of consecutive primes
    ];

    testCases.forEach((testCase, index) => {
        test(`Test case ${index}`, () => {
            expect(skjkasdkd(testCase)).toBe(findLargestPrimeDigitSum(testCase));
        });
    });
});