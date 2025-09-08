function containsNearbyElements(values, limit) {
    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                let gap = Math.abs(values[index] - values[innerIndex]);
                if (gap < limit) {
                    return true;
                }
            }
            innerIndex += 1;
        }
        index += 1;
    }

    return false;
}

// method name: hasCloseElements -> containsNearbyElements
// parameter name: numbers -> values, threshold -> limit
// changed for loops to while loops
// variable name: idx -> index, idx2 -> innerIndex, elem -> values[index], elem2 -> values[innerIndex], distance -> gap
// replaced if not condition with direct comparison