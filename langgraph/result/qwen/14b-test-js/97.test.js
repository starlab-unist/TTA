// Source Code
function multiply(a, b) {
    return Math.abs(a % 10) * Math.abs(b % 10);
}

// Transformed Code (Semantically Equivalent)
function calculateUnitDigitProduct(x, y) {
    const unitDigitX = Math.abs(x % 10);
    const unitDigitY = Math.abs(y % 10);
    const product = unitDigitX * unitDigitY;
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

    test.each(testCases)('Input: (%d, %d)', (a, b) => {
        expect(multiply(a, b)).toBe(calculateUnitDigitProduct(a, b));
    });
});