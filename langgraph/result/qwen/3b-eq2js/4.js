function calculateMeanAbsoluteDev(values) {
    const average = values.reduce((sum, value) => sum + value, 0) / values.length;
    let deviationSum = 0;
    values.forEach(value => {
        deviationSum += Math.abs(value - average);
    });
    return deviationSum / values.length;
}

console.log(calculateMeanAbsoluteDev([1, 2, 3, 4, 5]));