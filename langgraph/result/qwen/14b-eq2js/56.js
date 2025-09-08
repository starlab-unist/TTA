function validateBracketSequence(sequence) {
    let level = 0;
    let index = 0;
    while (index < sequence.length) {
        if (sequence[index] === "<") {
            level += 1;
        } else {
            level -= 1;
        }
        if (level < 0) {
            return false;
        }
        index += 1;
    }
    return level === 0;
}