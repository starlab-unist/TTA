function willItFly(q, w) {
    if (q.reduce((acc, val) => acc + val, 0) > w) {
        return false;
    }

    let i = 0;
    let j = q.length - 1;
    while (i < j) {
        if (q[i] !== q[j]) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}