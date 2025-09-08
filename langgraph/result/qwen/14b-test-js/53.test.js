// Source Code
function add(x, y) {
    return x + y;
}

// Transformed Code (Semantically Equivalent)
function computeSum(a, b) {
    const total = a + b;
    return total;
}

// Test Cases
describe('add vs computeSum equivalence tests', () => {
    const testCases = [
        [1, 2],
        [-1, -1],
        [0, 0],
        [100, 200],
        [-50, 50],
        [123456789, 987654321],
        [0, 1],
        [10, -10],
        [999, 1],
        [1, 999]
    ];

    test.each(testCases)('Input: (%i, %i)', (x, y) => {
        expect(add(x, y)).toBe(computeSum(x, y));
    });
});