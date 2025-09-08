function verifyCyclicPattern(sequence, pattern) {
    const patternLength = pattern.length;
    const doubledPattern = pattern + pattern;
    let index = 0;

    while (index <= sequence.length - patternLength) {
        let subIndex = 0;
        while (subIndex <= patternLength) {
            if (sequence.slice(index, index + patternLength) === doubledPattern.slice(subIndex, subIndex + patternLength)) {
                return true;
            }
            subIndex++;
        }
        index++;
    }

    return false;
}