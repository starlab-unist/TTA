function computeRollingMaximum(numbers) {
    let currentMax = null;
    const maxHistory = [];

    let index = 0;
    while (index < numbers.length) {
        if (currentMax === null || numbers[index] > currentMax) {
            currentMax = numbers[index];
        }

        maxHistory.push(currentMax);
        index++;
    }

    return maxHistory;
}