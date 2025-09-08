function canItTakeOff(weights, maxWeight) {
    let totalWeight = weights.reduce((acc, weight) => acc + weight, 0);

    if (totalWeight > maxWeight) {
        return false;
    }

    let start = 0, end = weights.length - 1;
    while (start < end) {
        if (weights[start] !== weights[end]) {
            return false;
        }
        start += 1;
        end -= 1;
    }

    return true;
}