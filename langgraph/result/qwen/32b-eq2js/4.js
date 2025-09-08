function calculateMeanAbsDev(values) {
    const average = values.reduce((sum, value) => sum + value, 0) / values.length;
    const deviationSum = values.reduce((sum, value) => sum + Math.abs(value - average), 0);
    return deviationSum / values.length;
}