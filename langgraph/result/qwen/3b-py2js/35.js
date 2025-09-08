function maxElement(l) {
    let m = l[0];
    for (let e of l) {
        if (e > m) {
            m = e;
        }
    }
    return m;
}