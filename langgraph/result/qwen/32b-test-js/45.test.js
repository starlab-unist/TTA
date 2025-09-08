// Source Code
function triangleArea(a, h) {
    return a * h / 2.0;
}

// Transformed Code (Semantically Equivalent)
function calculateTriangleArea(base, height) {
    const area = (base * height) / 2.0;
    return area;
}

// Test Cases
describe('triangleArea vs calculateTriangleArea equivalence tests', () => {
    const testCases = [
        [10, 5],
        [7, 3],
        [0, 5],
        [5, 0],
        [0, 0],
        [2.5, 4.0],
        [100, 200],
        [1, 1],
        [3.14, 2.71],
        [12345, 6789]
    ];

    test.each(testCases)('Input: base = %s, height = %s', (base, height) => {
        expect(triangleArea(base, height)).toBe(calculateTriangleArea(base, height));
    });
});