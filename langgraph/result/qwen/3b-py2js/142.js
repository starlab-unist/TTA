function sumSquares(lst) {
    let result = [];
    for (let i = 0; i < lst.length; i++) {
        if (i % 3 === 0) {
            result.push(lst[i] ** 2);
        } else if (i % 4 === 0 && i % 3 !== 0) {
            result.push(lst[i] ** 3);
        } else {
            result.push(lst[i]);
        }
    }
    return result.reduce((acc, val) => acc + val, 0);
}