function cycpatternCheck(a, b) {
    const l = b.length;
    const pat = b + b;
    for (let i = 0; i <= a.length - l; i++) {
        for (let j = 0; j <= l; j++) {
            if (a.substring(i, i + l) === pat.substring(j, j + l)) {
                return true;
            }
        }
    }
    return false;
}