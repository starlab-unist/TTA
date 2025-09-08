// Source Code
function multiply(a, b) {
    return Math.abs(a % 10) * Math.abs(b % 10);
}

// Transformed Code (Semantically Equivalent)
function calculateUnitDigitProduct(a, b) {
    let unitDigitX = Math.abs(a % 10);
    let unitDigitY = Math.abs(b % 10);
    let product = unitDigitX * unitDigitY;
    return product;
}

// Test Cases
describe('multiply vs calculateUnitDigitProduct equivalence tests', () => {
    const testCases = [
        [123, 456],
        [-123, 456],
        [123, -456],
        [-123, -456],
        [0, 456],
        [123, 0],
        [0, 0],
        [789, 12345],
        [5, 9],
        [10, 10]
    ];

    test.each(testCases)('Input: a = %d, b = %d', (a, b) => {
        expect(multiply(a, b)).toBe(calculateUnitDigitProduct(a, b));
    });
});