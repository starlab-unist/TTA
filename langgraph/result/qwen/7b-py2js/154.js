function cycpatternCheck(a, b) {
    let l = b.length;
    let pat = b + b;
    for (let i = 0; i <= a.length - l; i++) {
        for (let j = 0; j <= l; j++) {
            if (a.slice(i, i + l) === pat.slice(j, j + l)) {
                return true;
            }
        }
    }
    return false;
}