function findMinimumPathValues(grid, k) {
    const n = grid.length;
    let val = n * n + 1;
    for (let row = 0; row < n; row++) {
        for (let col = 0; col < n; col++) {
            if (grid[row][col] === 1) {
                const neighbors = [];
                if (row > 0) {
                    neighbors.push(grid[row - 1][col]);
                }
                if (col > 0) {
                    neighbors.push(grid[row][col - 1]);
                }
                if (row < n - 1) {
                    neighbors.push(grid[row + 1][col]);
                }
                if (col < n - 1) {
                    neighbors.push(grid[row][col + 1]);
                }
                val = Math.min(...neighbors);
            }
        }
    }

    const ans = [];
    let i = 0;
    while (i < k) {
        if (i % 2 === 0) {
            ans.push(1);
        } else {
            ans.push(val);
        }
        i++;
    }

    return ans;
}