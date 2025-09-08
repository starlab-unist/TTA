function maxFill(grid, capacity) {
    return grid.map(arr => Math.ceil(arr.reduce((sum, value) => sum + value, 0) / capacity)).reduce((sum, value) => sum + value, 0);
}