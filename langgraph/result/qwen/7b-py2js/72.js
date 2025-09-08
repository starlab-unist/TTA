function willItFly(q, w) {
    if (q.reduce((a, b) => a + b, 0) > w) {
        return false;
    }

    let i = 0, j = q.length - 1;
    while (i < j) {
        if (q[i] !== q[j]) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}