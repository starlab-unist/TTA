function canItTakeOff(weights, maxWeight) {
    let totalWeight = weights.reduce((acc, weight) => acc + weight, 0);

    if (totalWeight > maxWeight) {
        return false;
    }

    let start = 0;
    let end = weights.length - 1;
    while (start < end) {
        if (weights[start] !== weights[end]) {
            return false;
        }
        start += 1;
        end -= 1;
    }

    return true;
}

// method name: will_it_fly -> can_it_take_off
// parameter name: q -> weights, w -> max_weight
// variable name: i -> start, j -> end, sum(q) -> total_weight
// replaced direct sum calculation with a variable for clarity
// maintained the while loop structure but renamed indices