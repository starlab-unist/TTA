// Source Code
function maxFill(grid, capacity) {
    return grid.reduce((total, arr) => total + Math.ceil(arr.reduce((sum, val) => sum + val, 0) / capacity), 0);
}

// Transformed Code (Semantically Equivalent)
function calculateMaxLoad(matrix, limit) {
    let totalLoad = 0;
    for (let row of matrix) {
        totalLoad += Math.ceil(row.reduce((sum, value) => sum + value, 0) / limit);
    }
    return totalLoad;
}

// Test Cases
describe('maxFill vs calculateMaxLoad equivalence tests', () => {
    const testCases = [
        [[[10, 20], [30, 40]], 10],
        [[[5, 5], [5, 5]], 5],
        [[[1, 1, 1], [2, 2, 2], [3, 3, 3]], 1],
        [[[0, 0], [0, 0]], 1],
        [[[7, 8, 9], [10, 11, 12]], 5],
        [[[100]], 10],
        [[[10, 20, 30], [40, 50, 60]], 25],
        [[[1, 2], [3, 4], [5, 6]], 3],
        [[[15, 15], [15, 15], [15, 15]], 10],
        [[[2, 4, 6], [8, 10, 12], [14, 16, 18]], 7]
    ];

    test.each(testCases)('Input: %p with capacity/limit: %p', (grid, capacity) => {
        expect(maxFill(grid, capacity)).toBe(calculateMaxLoad(grid, capacity));
    });
});