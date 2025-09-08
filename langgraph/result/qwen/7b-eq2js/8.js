function calculateAggregates(values) {
    let totalSum = 0;
    let cumulativeProduct = 1;

    let index = 0;
    while (index < values.length) {
        totalSum += values[index];
        cumulativeProduct *= values[index];
        index += 1;
    }

    return [totalSum, cumulativeProduct];
}

// function name: calculateAggregates
// parameter name: values
// variable names: totalSum, cumulativeProduct
// replaced for loop with while loop