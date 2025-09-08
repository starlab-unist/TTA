function maxFill(grid, capacity) {
    return grid.reduce((total, arr) => total + Math.ceil(arr.reduce((sum, val) => sum + val, 0) / capacity), 0);
}