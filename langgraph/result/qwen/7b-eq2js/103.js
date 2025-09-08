function calculateBinaryAverage(n, m) {
    if (m < n) {
        return -1;
    }
    let summation = 0;
    let i = n;
    while (i <= m) {
        summation += i;
        i++;
    }
    const average = Math.round(summation / (m - n + 1));
    return average.toString(2);
}