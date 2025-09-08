// Source Code
function getRow(lst, x) {
    let coords = [];
    for (let i = 0; i < lst.length; i++) {
        for (let j = 0; j < lst[i].length; j++) {
            if (lst[i][j] === x) {
                coords.push([i, j]);
            }
        }
    }
    return coords.sort((a, b) => a[1] - b[1]).sort((a, b) => b[0] - a[0]);
}

// Transformed Code (Semantically Equivalent)
function findCoordinates(lst, x) {
    let positions = [];
    for (let row_index = 0; row_index < lst.length; row_index++) {
        for (let col_index = 0; col_index < lst[row_index].length; col_index++) {
            if (lst[row_index][col_index] === x) {
                positions.push([row_index, col_index]);
            }
        }
    }

    let sortedPositions = positions.sort((a, b) => b[1] - a[1]).sort((a, b) => b[0] - a[0]);
    return sortedPositions;
}

// Jest Test Cases
describe('getRow and findCoordinates', () => {
    const testCases = [
        [[[1, 2, 3], [4, 5, 6], [7, 8, 9]], 5],
        [[[1, 1, 1], [1, 1, 1], [1, 1, 1]], 1],
        [[[0, 0, 0], [0, 0, 0], [0, 0, 0]], 0],
        [[[1, 2, 3], [4, 5, 6], [7, 8, 9]], 10],
        [[[1, 2, 3], [3, 4, 5], [5, 6, 7]], 3],
        [[[10, 20, 30], [40, 50, 60], [70, 80, 90]], 60],
        [[['a', 'b'], ['c', 'd'], ['e', 'f']], 'd'],
        [['x', 'y', 'z'], ['x', 'y', 'z'], ['x', 'y', 'z']], 'x'],
        [[[1, 2], [3, 4]], 4],
        [[[7, 8], [9, 10], [11, 12]], 7]
    ];

    test.each(testCases)('should return the same result for getRow and findCoordinates', (lst, x) => {
        expect(getRow(lst, x)).toEqual(findCoordinates(lst, x));
    });
});