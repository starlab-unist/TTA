function determineNearestPair(values) {
    let nearestPair = null;
    let minGap = Infinity;

    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                const currentDifference = Math.abs(values[index] - values[innerIndex]);
                if (currentDifference < minGap) {
                    minGap = currentDifference;
                    nearestPair = [Math.min(values[index], values[innerIndex]), Math.max(values[index], values[innerIndex])];
                }
            }
            innerIndex++;
        }
        index++;
    }

    return nearestPair;
}