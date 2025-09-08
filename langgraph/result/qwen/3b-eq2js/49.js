function modp(n, p) {
    let ret = 1;
    let i = 0;
    while (i < n) {
        ret = (2 * ret) % p;
        i++;
    }
    return ret;
}