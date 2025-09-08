function sumSquares(arr) {
    let result = [];
    for (let i = 0; i < arr.length; i++) {
        if (i % 3 === 0) {
            result.push(arr[i] ** 2);
        } else if (i % 4 === 0 && i % 3 !== 0) {
            result.push(arr[i] ** 3);
        } else {
            result.push(arr[i]);
        }
    }
    return result.reduce((acc, val) => acc + val, 0);
}