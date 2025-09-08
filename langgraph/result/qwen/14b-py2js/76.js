function isSimplePower(x, n) {
    if (n === 1) {
        return x === 1;
    }
    let power = 1;
    while (power < x) {
        power *= n;
    }
    return power === x;
}