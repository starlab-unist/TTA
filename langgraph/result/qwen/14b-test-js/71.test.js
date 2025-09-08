// Source Code
function triangleArea(a, b, c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
        return -1;
    }
    const s = (a + b + c) / 2;
    let area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    area = Math.round(area * 100) / 100;
    return area;
}

// Transformed Code (Semantically Equivalent)
function computeTriangleArea(side1, side2, side3) {
    if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
        return -1;
    }
    
    const semiPerimeter = (side1 + side2 + side3) / 2;
    const computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    const roundedArea = Math.round(computedArea * 100) / 100;
    
    return roundedArea;
}

// Test Cases
describe('triangleArea vs computeTriangleArea equivalence tests', () => {
    const testCases = [
        [3, 4, 5],      // valid triangle
        [10, 6, 8],     // valid triangle
        [7, 10, 5],     // valid triangle
        [1, 1, 2],      // invalid triangle
        [5, 5, 5],      // equilateral triangle
        [0, 4, 5],      // invalid triangle with zero side
        [-3, 4, 5],     // invalid triangle with negative side
        [6, 8, 10],     // valid right triangle
        [2, 2, 3.464],  // valid isosceles triangle
        [12, 5, 13]     // valid triangle
    ];

    test.each(testCases)('Input: (%s, %s, %s)', (a, b, c) => {
        expect(triangleArea(a, b, c)).toBe(computeTriangleArea(a, b, c));
    });
});