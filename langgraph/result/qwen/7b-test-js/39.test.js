// Source Code
function primeFib(n) {
    function isPrime(p) {
        if (p < 2) return false;
        for (let k = 2; k <= Math.min(Math.floor(Math.sqrt(p)), p - 2); k++) {
            if (p % k === 0) return false;
        }
        return true;
    }

    let f = [0, 1];
    while (true) {
        f.push(f[f.length - 1] + f[f.length - 2]);
        if (isPrime(f[f.length - 1])) {
            n--;
        }
        if (n === 0) {
            return f[f.length - 1];
        }
    }
}

// Transformed Code (Semantically Equivalent)
function findNthPrimeFibonacci(n) {
    function checkPrime(number) {
        if (number < 2) return false;
        let limit = Math.min(Math.floor(Math.sqrt(number)) + 1, number - 1);
        let divisor = 2;
        while (divisor < limit) {
            if (number % divisor === 0) return false;
            divisor += 1;
        }
        return true;
    }

    let fibonacciSequence = [0, 1];
    while (true) {
        let nextFib = fibonacciSequence[fibonacciSequence.length - 1] + fibonacciSequence[fibonacciSequence.length - 2];
        fibonacciSequence.push(nextFib);
        if (checkPrime(nextFib)) {
            n -= 1;
        }
        if (n === 0) {
            return nextFib;
        }
    }
}

// Test Cases
describe('primeFib vs findNthPrimeFibonacci equivalence tests', () => {
    const testCases = [
        1,  // First prime Fibonacci number is 2
        2,  // Second prime Fibonacci number is 3
        3,  // Third prime Fibonacci number is 5
        4,  // Fourth prime Fibonacci number is 13
        5,  // Fifth prime Fibonacci number is 89
        6,  // Sixth prime Fibonacci number is 233
        7,  // Seventh prime Fibonacci number is 1597
        8,  // Eighth prime Fibonacci number is 28657
        9,  // Ninth prime Fibonacci number is 514229
        10  // Tenth prime Fibonacci number is 433494437
    ];

    testCases.forEach((testCase) => {
        it(`should return the same result for n = ${testCase}`, () => {
            expect(primeFib(testCase)).toBe(findNthPrimeFibonacci(testCase));
        });
    });
});