function selectNumber(x, y) {
    if (x > y) {
        return -1;
    } else if (y % 2 === 0) {
        return y;
    } else if (x === y) {
        return -1;
    } else {
        return y - 1;
    }
}