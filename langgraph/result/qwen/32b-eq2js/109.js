function checkSortedAfterRotation(sequence) {
    if (!sequence.length) {
        return true;
    }

    const orderedSequence = [...sequence].sort((a, b) => a - b);
    const smallestElement = Math.min(...sequence);
    const pivotIndex = sequence.indexOf(smallestElement);

    const rotatedSequence = sequence.slice(pivotIndex).concat(sequence.slice(0, pivotIndex));

    for (let idx = 0; idx < sequence.length; idx++) {
        if (rotatedSequence[idx] !== orderedSequence[idx]) {
            return false;
        }
    }

    return true;
}