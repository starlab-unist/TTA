// Source Code
function triangleArea(a, h) {
    return a * h / 2.0;
}

// Transformed Code (Semantically Equivalent)
function calculateTriangleArea(a, h) {
    let area = (a * h) / 2.0;
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

    test.each(testCases)('Input: a=%s, h=%s', (a, h) => {
        expect(triangleArea(a, h)).toBe(calculateTriangleArea(a, h));
    });
});