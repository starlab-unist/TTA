function getRow(lst, x) {
    const coords = [];
    for (let i = 0; i < lst.length; i++) {
        for (let j = 0; j < lst[i].length; j++) {
            if (lst[i][j] === x) {
                coords.push([i, j]);
            }
        }
    }
    return coords.sort((a, b) => a[0] - b[0]).sort((a, b) => b[1] - a[1]);
}