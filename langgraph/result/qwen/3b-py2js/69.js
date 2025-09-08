function search(lst) {
    const maxVal = Math.max(...lst);
    const frq = new Array(maxVal + 1).fill(0);

    for (let i of lst) {
        frq[i]++;
    }

    let ans = -1;
    for (let i = 1; i <= frq.length; i++) {
        if (frq[i] >= i) {
            ans = i;
        }
    }

    return ans;
}