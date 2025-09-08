function verifyCyclicPattern(sequence, pattern) {
    const patternLength = pattern.length;
    const doubledPattern = pattern + pattern;
    let index = 0;
    
    while (index <= sequence.length - patternLength) {
        let subIndex = 0;
        while (subIndex <= patternLength) {
            if (sequence.substring(index, index + patternLength) === doubledPattern.substring(subIndex, subIndex + patternLength)) {
                return true;
            }
            subIndex += 1;
        }
        index += 1;
    }
    
    return false;
}