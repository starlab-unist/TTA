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
    coords.sort((a, b) => a[1] - b[1]).sort((a, b) => b[0] - a[0]);
    return coords;
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

    const sortedPositions = positions.sort((a, b) => a[1] - b[1]).sort((a, b) => b[0] - a[0]);
    return sortedPositions;
}

// Jest Test Cases
describe('getRow and findCoordinates', () => {
    test('Test Case 0', () => {
        expect(getRow([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 5)).toEqual(findCoordinates([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 5));
    });

    test('Test Case 1', () => {
        expect(getRow([[1, 1, 1], [1, 1, 1], [1, 1, 1]], 1)).toEqual(findCoordinates([[1, 1, 1], [1, 1, 1], [1, 1, 1]], 1));
    });

    test('Test Case 2', () => {
        expect(getRow([[0, 0, 0], [0, 0, 0], [0, 0, 0]], 0)).toEqual(findCoordinates([[0, 0, 0], [0, 0, 0], [0, 0, 0]], 0));
    });

    test('Test Case 3', () => {
        expect(getRow([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 10)).toEqual(findCoordinates([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 10));
    });

    test('Test Case 4', () => {
        expect(getRow([[1, 2, 3], [3, 4, 5], [5, 6, 7]], 3)).toEqual(findCoordinates([[1, 2, 3], [3, 4, 5], [5, 6, 7]], 3));
    });

    test('Test Case 5', () => {
        expect(getRow([[10, 20, 30], [40, 50, 60], [70, 80, 90]], 60)).toEqual(findCoordinates([[10, 20, 30], [40, 50, 60], [70, 80, 90]], 60));
    });

    test('Test Case 6', () => {
        expect(getRow([['a', 'b'], ['c', 'd'], ['e', 'f']], 'd')).toEqual(findCoordinates([['a', 'b'], ['c', 'd'], ['e', 'f']], 'd'));
    });

    test('Test Case 7', () => {
        expect(getRow([['x', 'y', 'z'], ['x', 'y', 'z'], ['x', 'y', 'z']], 'x')).toEqual(findCoordinates([['x', 'y', 'z'], ['x', 'y', 'z'], ['x', 'y', 'z']], 'x'));
    });

    test('Test Case 8', () => {
        expect(getRow([[1, 2], [3, 4]], 4)).toEqual(findCoordinates([[1, 2], [3, 4]], 4));
    });

    test('Test Case 9', () => {
        expect(getRow([[7, 8], [9, 10], [11, 12]], 7)).toEqual(findCoordinates([[7, 8], [9, 10], [11, 12]], 7));
    });
});