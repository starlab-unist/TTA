function findCoordinates(matrix, target) {
    let positions = [];
    for (let row_index = 0; row_index < matrix.length; row_index++) {
        for (let col_index = 0; col_index < matrix[row_index].length; col_index++) {
            if (matrix[row_index][col_index] === target) {
                positions.push([row_index, col_index]);
            }
        }
    }

    let sortedPositions = positions.sort((a, b) => b[1] - a[1]);
    let finalSortedPositions = sortedPositions.sort((a, b) => a[0] - b[0]);
    return finalSortedPositions;
}