function xOrY(n, x, y) {
    if (n === 1) {
        return y;
    }
    for (let i = 2; i < n; i++) {
        if (n % i === 0) {
            return y;
            break;
        }
    }
    else {
        return x;
    }
}