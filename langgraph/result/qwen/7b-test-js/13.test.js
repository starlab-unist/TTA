// Source Code
function greatestCommonDivisor(a, b) {
    while (b !== 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// Transformed Code (Semantically Equivalent)
function findHighestCommonFactor(num1, num2) {
    while (num2 !== 0) {
        let remainder = num1 % num2;
        num1 = num2;
        num2 = remainder;
    }
    return num1;
}

// Test Cases
describe('greatestCommonDivisor vs findHighestCommonFactor equivalence tests', () => {
    const testCases = [
        [48, 18],  // GCD is 6
        [56, 98],  // GCD is 14
        [101, 103], // GCD is 1 (prime numbers)
        [270, 192], // GCD is 6
        [0, 5],    // GCD is 5
        [5, 0],    // GCD is 5
        [0, 0],    // GCD is 0
        [20, 30],  // GCD is 10
        [7, 3],    // GCD is 1
        [100, 10]  // GCD is 10
    ];

    test.each(testCases)('Input: (%s, %s)', (a, b) => {
        expect(greatestCommonDivisor(a, b)).toBe(findHighestCommonFactor(a, b));
    });
});