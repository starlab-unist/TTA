function calculateMeanAbsDev(values) {
    const average = values.reduce((acc, val) => acc + val, 0) / values.length;
    const deviationSum = values.reduce((acc, val) => acc + Math.abs(val - average), 0);
    return deviationSum / values.length;
}

// method name: mean_absolute_deviation -> calculateMeanAbsDev
// parameter name: numbers -> values
// variable name: mean -> average, counts -> deviationSum
// changed the order of operations slightly by storing the sum of deviations in a variable