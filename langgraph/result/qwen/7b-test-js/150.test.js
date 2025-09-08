// Source Code
function xOrY(n, x, y) {
    if (n === 1) {
        return y;
    }
    for (let i = 2; i < n; i++) {
        if (n % i === 0) {
            return y;
            break;
        }
    }
    return x;
}

// Transformed Code (Semantically Equivalent)
function determineValueBasedOnDivisibility(n, x, y) {
    if (n === 1) {
        return y;
    }

    let divisor = 2;
    while (divisor < n) {
        if (n % divisor === 0) {
            return y;
        }
        divisor += 1;
    }
    return x;
}

// Test Cases
describe('xOrY vs determineValueBasedOnDivisibility equivalence tests', () => {
    const testCases = [
        [1, "not_prime", "prime"],
        [2, "not_prime", "prime"],
        [3, "not_prime", "prime"],
        [4, "not_prime", "prime"],
        [5, "not_prime", "prime"],
        [6, "not_prime", "prime"],
        [7, "not_prime", "prime"],
        [8, "not_prime", "prime"],
        [9, "not_prime", "prime"],
        [10, "not_prime", "prime"]
    ];

    test.each(testCases)('Input: n=%d, x="%s", y="%s"', (n, x, y) => {
        expect(xOrY(n, x, y)).toBe(determineValueBasedOnDivisibility(n, x, y));
    });
});