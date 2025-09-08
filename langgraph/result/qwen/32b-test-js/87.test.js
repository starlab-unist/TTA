// Source Code
function getRow(lst, x) {
    const coords = [];
    for (let i = 0; i < lst.length; i++) {
        for (let j = 0; j < lst[i].length; j++) {
            if (lst[i][j] === x) {
                coords.push([i, j]);
            }
        }
    }
    return coords.sort((a, b) => a[0] - b[0]).sort((a, b) => b[1] - a[1]);
}

// Transformed Code (Semantically Equivalent)
function findCoordinates(matrix, target) {
    const positions = [];
    for (let rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
        const row = matrix[rowIndex];
        for (let colIndex = 0; colIndex < row.length; colIndex++) {
            const value = row[colIndex];
            if (value === target) {
                positions.push([rowIndex, colIndex]);
            }
        }
    }

    const sortedPositions = positions.sort((a, b) => b[1] - a[1]);
    const finalSortedPositions = sortedPositions.sort((a, b) => a[0] - b[0]);
    return finalSortedPositions;
}

// Jest Test Suite
describe('getRow and findCoordinates', () => {
    const testCases = [
        [[[1, 2, 3], [4, 5, 6], [7, 8, 9]], 5],
        [[[1, 1, 1], [1, 1, 1], [1, 1, 1]], 1],
        [[[0, 0, 0], [0, 0, 0], [0, 0, 0]], 0],
        [[[1, 2, 3], [4, 5, 6], [7, 8, 9]], 10],
        [[[1, 2, 3], [3, 4, 5], [5, 6, 7]], 3],
        [[[10, 20, 30], [40, 50, 60], [70, 80, 90]], 60],
        [['a', 'b'], ['c', 'd'], ['e', 'f']], 'd'],
        [['x', 'y', 'z'], ['x', 'y', 'z'], ['x', 'y', 'z']], 'x'],
        [[[1, 2], [3, 4]], 4],
        [[[7, 8], [9, 10], [11, 12]], 7]
    ];

    testCases.forEach(([matrix, target], index) => {
        it(`should return the same result for test case ${index + 1}`, () => {
            expect(getRow(matrix, target)).toEqual(findCoordinates(matrix, target));
        });
    });
});