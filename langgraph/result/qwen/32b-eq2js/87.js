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