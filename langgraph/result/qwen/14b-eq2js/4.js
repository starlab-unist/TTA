function calculateMeanAbsDev(values) {
    const average = values.reduce((sum, value) => sum + value, 0) / values.length;
    const deviationSum = values.reduce((sum, value) => sum + Math.abs(value - average), 0);
    return deviationSum / values.length;
}

// method name: mean_absolute_deviation -> calculateMeanAbsDev
// parameter name: numbers -> values
// variable name: mean -> average, counts -> deviationSum
// changed the order of operations slightly by storing the sum of deviations in a variable