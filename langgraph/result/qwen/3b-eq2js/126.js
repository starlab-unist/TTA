function checkSortedSequence(sequence) {
    const digitCount = {};
    for (let number of sequence) {
        digitCount[number] = (digitCount[number] || 0) + 1;
    }

    if (Object.values(digitCount).some(count => count > 2)) {
        return false;
    }

    let index = 1;
    while (index < sequence.length) {
        if (sequence[index - 1] > sequence[index]) {
            return false;
        }
        index++;
    }

    return true;
}