function changeBase(x, base) {
    let ret = "";
    while (x > 0) {
        ret = (x % base).toString() + ret;
        x = Math.floor(x / base);
    }
    return ret;
}