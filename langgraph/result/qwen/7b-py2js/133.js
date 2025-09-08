function sumSquares(arr) {
    let squared = 0;
    for (let i of arr) {
        squared += Math.pow(Math.ceil(i), 2);
    }
    return squared;
}