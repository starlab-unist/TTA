function minimalAdjustments(sequence) {
    let adjustmentsNeeded = 0;
    let index = 0;
    while (index < sequence.length / 2) {
        if (sequence[index] !== sequence[sequence.length - index - 1]) {
            adjustmentsNeeded += 1;
        }
        index += 1;
    }
    return adjustmentsNeeded;
}