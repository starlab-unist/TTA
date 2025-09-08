function canItTakeOff(weights, maxWeight) {
    let totalWeight = 0;

    for (let i = 0; i < weights.length; i++) {
        totalWeight += weights[i];
    }

    if (totalWeight > maxWeight) {
        return false;
    }

    let start = 0;
    let end = weights.length - 1;
    while (start < end) {
        if (weights[start] !== weights[end]) {
            return false;
        }
        start++;
        end--;
    }

    return true;
}