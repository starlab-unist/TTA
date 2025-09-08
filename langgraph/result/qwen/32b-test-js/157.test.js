// Source Code
function rightAngleTriangle(a, b, c) {
    return a * a === b * b + c * c || b * b === a * a + c * c || c * c === a * a + b * b;
}

// Transformed Code (Semantically Equivalent)
function isRightAngled(x, y, z) {
    const sidesSquared = [x**2, y**2, z**2];
    sidesSquared.sort((a, b) => a - b);
    return sidesSquared[0] + sidesSquared[1] === sidesSquared[2];
}

// Test Cases
describe('rightAngleTriangle vs isRightAngled equivalence tests', () => {
    const testCases = [
        [3, 4, 5],   // True: 3^2 + 4^2 = 5^2
        [5, 12, 13], # True: 5^2 + 12^2 = 13^2
        [1, 1, 1],   # False: not a right triangle
        [6, 8, 10],  # True: 6^2 + 8^2 = 10^2
        [7, 24, 25], # True: 7^2 + 24^2 = 25^2
        [9, 40, 41], # True: 9^2 + 40^2 = 41^2
        [2, 2, 3],   # False: not a right triangle
        [8, 15, 17], # True: 8^2 + 15^2 = 17^2
        [10, 24, 26],# True: 10^2 + 24^2 = 26^2
        [5, 5, 7]    # False: not a right triangle
    ];

    test.each(testCases)('Input: (%i, %i, %i)', (a, b, c) => {
        expect(rightAngleTriangle(a, b, c)).toBe(isRightAngled(a, b, c));
    });
});