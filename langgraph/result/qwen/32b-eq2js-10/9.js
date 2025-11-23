function computeRollingMaximum(values) {
    let currentMax = null;
    const maxHistory = [];

    let index = 0;
    while (index < values.length) {
        if (currentMax === null) {
            currentMax = values[index];
        } else if (values[index] > currentMax) {
            currentMax = values[index];
        }

        maxHistory.push(currentMax);
        index += 1;
    }

    return maxHistory;
}