function calculateMaxLoad(matrix, limit) {
    let totalLoad = 0;
    for (let row of matrix) {
        totalLoad += Math.ceil(row.reduce((sum, value) => sum + value, 0) / limit);
    }
    return totalLoad;
}