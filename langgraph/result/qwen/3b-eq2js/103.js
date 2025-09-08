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
    const average = Math.round(totalSum / (end - start + 1));
    return `0b${average.toString(2)}`;
}

// method name: rounded_avg -> calculateBinaryAverage
// parameter name: n -> start, m -> end
// variable name: summation -> totalSum, i -> current
// replaced for loop with while loop
// separated the calculation of average for clarity