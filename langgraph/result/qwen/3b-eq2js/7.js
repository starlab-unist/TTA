function extractMatchingStrings(sequence, pattern) {
    const result = [];
    let index = 0;
    while (index < sequence.length) {
        if (sequence[index].includes(pattern)) {
            result.push(sequence[index]);
        }
        index++;
    }
    return result;
}