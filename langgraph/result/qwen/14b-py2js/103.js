function roundedAvg(n, m) {
    if (m < n) {
        return -1;
    }
    let summation = 0;
    for (let i = n; i <= m; i++) {
        summation += i;
    }
    return (Math.round(summation / (m - n + 1))).toString(2);
}