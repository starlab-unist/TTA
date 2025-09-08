function analyzeParenthesesDepth(parenSequence) {
    function calculateMaxNestingLevel(substring) {
        let currentLevel = 0;
        let peakLevel = 0;
        for (let character of substring) {
            if (character === '(') {
                currentLevel++;
                peakLevel = Math.max(currentLevel, peakLevel);
            } else if (character === ')') {
                currentLevel--;
            }
        }

        return peakLevel;
    }

    return parenSequence.split().map(segment => calculateMaxNestingLevel(segment));
}