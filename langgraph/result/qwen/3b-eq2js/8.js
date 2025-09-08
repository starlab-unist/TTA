function calculateAggregates(values) {
    let totalSum = 0;
    let cumulativeProduct = 1;

    let index = 0;
    while (index < values.length) {
        totalSum += values[index];
        cumulativeProduct *= values[index];
        index++;
    }

    return [totalSum, cumulativeProduct];
}

// method name: sum_product -> calculateAggregates
// parameter name: numbers -> values
// variable name: sum_value -> totalSum, prod_value -> cumulativeProduct
// replaced for loop with while loop