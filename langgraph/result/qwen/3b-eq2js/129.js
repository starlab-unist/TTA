function findMinimumPathValues(matrix, count) {
    const size = matrix.length;
    let minimumValue = size * size + 1;

    for (let row = 0; row < size; row++) {
        for (let col = 0; col < size; col++) {
            if (matrix[row][col] === 1) {
                let neighbors = [];
                if (row > 0) {
                    neighbors.push(matrix[row - 1][col]);
                }
                if (col > 0) {
                    neighbors.push(matrix[row][col - 1]);
                }
                if (row < size - 1) {
                    neighbors.push(matrix[row + 1][col]);
                }
                if (col < size - 1) {
                    neighbors.push(matrix[row][col + 1]);
                }

                minimumValue = Math.min(...neighbors);
            }
        }
    }

    const result = [];
    let index = 0;
    while (index < count) {
        if (index % 2 === 0) {
            result.push(1);
        } else {
            result.push(minimumValue);
        }
        index++;
    }

    return result;
}