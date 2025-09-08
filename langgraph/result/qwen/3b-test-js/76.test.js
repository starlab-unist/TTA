// Source Code
function isSimplePower(x, n) {
    if (n === 1) {
        return (x === 1);
    }
    let power = 1;
    while (power < x) {
        power *= n;
    }
    return (power === x);
}

// Transformed Code (Semantically Equivalent)
function checkPowerRelation(base, exponent) {
    if (exponent === 1) {
        return base === 1;
    }

    let currentValue = 1;
    while (currentValue < base) {
        currentValue *= exponent;
    }

    return currentValue === base;
}

// Test Cases
describe('isSimplePower vs checkPowerRelation equivalence tests', () => {
    const testCases = [
        [1, 1],     // True: 1^1 = 1
        [8, 2],     // False: No power of 2 equals 8 exactly within the loop
        [9, 3],     // True: 3^2 = 9
        [27, 3],    // True: 3^3 = 27
        [16, 4],    // True: 4^2 = 16
        [10, 10],   // True: 10^1 = 10
        [256, 2],   // True: 2^8 = 256
        [1, 5],     // False: 5^0 = 1, but loop condition fails for x > 1 when n > 1
        [0, 2],     // False: No power of 2 equals 0
        [7, 3]      // False: No power of 3 equals 7 exactly within the loop
    ];

    test.each(testCases)('Input: x=%i, n=%i', (x, n) => {
        expect(isSimplePower(x, n)).toBe(checkPowerRelation(x, n));
    });
});