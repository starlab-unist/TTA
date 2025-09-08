function validateBracketSequence(sequence) {
    let level = 0;
    let index = 0;
    while (index < sequence.length) {
        if (sequence[index] === "<") {
            level++;
        } else {
            level--;
        }
        if (level < 0) {
            return false;
        }
        index++;
    }
    return level === 0;
}