function computeRollingMaximum(values) {
    let currentMax = null;
    const maxHistory = [];

    let index = 0;
    while (index < values.length) {
        if (currentMax === null || values[index] > currentMax) {
            currentMax = values[index];
        }

        maxHistory.push(currentMax);
        index++;
    }

    return maxHistory;
}

// method name: rolling_max -> computeRollingMaximum
// parameter name: numbers -> values
// variable name: running_max -> currentMax, result -> maxHistory
// replaced for loop with while loop and index increment
// simplified the condition for updating currentMax