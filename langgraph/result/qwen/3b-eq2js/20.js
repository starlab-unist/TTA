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
                    nearestPair = [Math.min(values[index], values[innerIndex]), Math.max(values[index], values[innerIndex])];
                }
            }
            innerIndex++;
        }
        index++;
    }

    return nearestPair;
}

// method name: findClosestElements -> determineNearestPair
// parameter name: numbers -> values
// variable name: closestPair -> nearestPair, distance -> minGap
// changed for loops to while loops
// simplified the initial check for minGap