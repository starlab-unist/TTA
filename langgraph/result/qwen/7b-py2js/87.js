function getRow(lst, x) {
    let coords = [];
    for (let i = 0; i < lst.length; i++) {
        for (let j = 0; j < lst[i].length; j++) {
            if (lst[i][j] === x) {
                coords.push([i, j]);
            }
        }
    }
    return coords.sort((a, b) => a[1] - b[1]).sort((a, b) => b[0] - a[0]);
}