function arrangeSequence(sequence) {
    if (!sequence.length) {
        return [];
    }
    
    const reverseOrder = (sequence[0] + sequence[sequence.length - 1]) % 2 === 0;
    return sequence.sort((a, b) => reverseOrder ? b - a : a - b);
}