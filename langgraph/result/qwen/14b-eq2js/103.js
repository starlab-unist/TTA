function calculateBinaryAverage(start, end) {
    if (end < start) {
        return -1;
    }
    let totalSum = 0;
    let current = start;
    while (current <= end) {
        totalSum += current;
        current += 1;
    }
    let average = Math.round(totalSum / (end - start + 1));
    return '0b' + average.toString(2);
}