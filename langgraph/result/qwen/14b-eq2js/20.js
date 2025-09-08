function determineNearestPair(values) {
    let nearestPair = null;
    let minGap = null;

    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                const currentDifference = Math.abs(values[index] - values[innerIndex]);
                if (minGap === null || currentDifference < minGap) {
                    minGap = currentDifference;
                    nearestPair = [values[index], values[innerIndex]].sort((a, b) => a - b);
                }
            }
            innerIndex += 1;
        }
        index += 1;
    }

    return nearestPair;
}