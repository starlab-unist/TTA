function analyzeParenthesesDepth(parenSequence) {
    function calculateMaxNestingLevel(substring) {
        let currentLevel = 0;
        let peakLevel = 0;
        for (let character of substring) {
            if (character === '(') {
                currentLevel += 1;
                peakLevel = Math.max(currentLevel, peakLevel);
            } else if (character === ')') {
                currentLevel -= 1;
            }
        }

        return peakLevel;
    }

    return parenSequence.split(/\s+/).map(segment => segment && calculateMaxNestingLevel(segment));
}