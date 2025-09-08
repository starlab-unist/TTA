// Source Code
function countUpTo(n) {
    let primes = [];
    for (let i = 2; i < n; i++) {
        let isPrime = true;
        for (let j = 2; j < i; j++) {
            if (i % j === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            primes.push(i);
        }
    }
    return primes;
}

// Transformed Code (Semantically Equivalent)
function findPrimesBelow(n) {
    let primeNumbers = [];
    let candidate = 2;
    while (candidate < n) {
        let divisor = 2;
        let isDivisible = false;
        while (divisor < candidate) {
            if (candidate % divisor === 0) {
                isDivisible = true;
                break;
            }
            divisor += 1;
        }
        if (!isDivisible) {
            primeNumbers.push(candidate);
        }
        candidate += 1;
    }
    return primeNumbers;
}

// Test Cases
describe('countUpTo vs findPrimesBelow equivalence tests', () => {
    const testCases = [
        10,  // Simple case with multiple primes below the limit
        2,   // Edge case where limit is less than the smallest prime
        3,   // Case where there's only one prime below the limit
        20,  // Larger number to check performance and correctness
        1,   // Edge case where limit is 1
        0,   // Edge case where limit is 0
        5,   // Simple case with multiple primes below the limit
        15,  // Case with some primes but not many
        29,  // Prime number itself as the limit
        30   // Number just above a prime to check if it includes that prime
    ];

    test.each(testCases)('Input: %d', (inputValue) => {
        expect(countUpTo(inputValue)).toEqual(findPrimesBelow(inputValue));
    });
});