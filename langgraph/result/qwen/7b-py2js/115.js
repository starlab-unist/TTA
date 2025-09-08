function maxFill(grid, capacity) {
    return grid.reduce((acc, arr) => acc + Math.ceil(arr.reduce((sum, val) => sum + val, 0) / capacity), 0);
}