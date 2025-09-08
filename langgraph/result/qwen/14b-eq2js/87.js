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

    const sortedPositions = positions.sort((pos1, pos2) => pos2[1] - pos1[1]);
    const finalSortedPositions = sortedPositions.sort((pos1, pos2) => pos1[0] - pos2[0]);
    return finalSortedPositions;
}