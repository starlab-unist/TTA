function roundedAvg(n, m) {
    if (m < n) {
        return -1;
    }
    let summation = 0;
    for (let i = n; i <= m; i++) {
        summation += i;
    }
    const average = Math.round(summation / (m - n + 1));
    return average.toString(2);
}