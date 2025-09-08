function calculateMaxLoad(grid, capacity) {
    let totalLoad = 0;
    for (let row of grid) {
        totalLoad += Math.ceil(row.reduce((acc, val) => acc + val, 0) / capacity);
    }
    return totalLoad;
}