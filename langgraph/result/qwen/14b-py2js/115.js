function maxFill(grid, capacity) {
    return grid.reduce((total, arr) => total + Math.ceil(arr.reduce((sum, num) => sum + num, 0) / capacity), 0);
}