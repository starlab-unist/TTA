function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) {
        return false;
    }
    for (let char of set0) {
        if (!set1.has(char)) {
            return false;
        }
    }
    return true;
}