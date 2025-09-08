// Source Code
function parseNestedParens(parenString) {
    function parseParenGroup(s) {
        let depth = 0;
        let maxDepth = 0;
        for (let c of s) {
            if (c === '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if (c === ')') {
                depth--;
            }
        }

        return maxDepth;
    }

    return parenString.split(' ').filter(x => x).map(parseParenGroup);
}

// Transformed Code (Semantically Equivalent)
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

    return parenSequence.split(' ').map(segment => calculateMaxNestingLevel(segment));
}

// Test Cases
describe('parseNestedParens vs analyzeParenthesesDepth equivalence tests', () => {
    const testCases = [
        "(()) ()",
        "((())) (()) ()",
        "()",
        "((( ))) (( )) ( )",
        "",
        "(()(()))",
        "((()()()))",
        "((())) () ()",
        "(((())))",
        "() () ()"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(parseNestedParens(inputText)).toEqual(analyzeParenthesesDepth(inputText));
    });
});