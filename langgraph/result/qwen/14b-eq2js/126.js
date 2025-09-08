function checkSortedSequence(sequence) {
    const digitCount = {};
    for (const num of sequence) {
        digitCount[num] = (digitCount[num] || 0) + 1;
    }
    
    for (const num in digitCount) {
        if (digitCount[num] > 2) {
            return false;
        }
    }
    
    let index = 1;
    while (index < sequence.length) {
        if (sequence[index - 1] > sequence[index]) {
            return false;
        }
        index += 1;
    }
    
    return true;
}