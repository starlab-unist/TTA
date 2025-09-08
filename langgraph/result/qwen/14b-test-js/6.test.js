// Source Code
function parseNestedParens(parenString) {
    function parseParenGroup(s) {
        let depth = 0;
        let maxDepth = 0;
        for (let c of s) {
            if (c === '(') {
                depth += 1;
                maxDepth = Math.max(depth, maxDepth);
            } else {
                depth -= 1;
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
                currentLevel += 1;
                peakLevel = Math.max(currentLevel, peakLevel);
            } else if (character === ')') {
                currentLevel -= 1;
            }
        }
        return peakLevel;
    }

    return parenSequence.split(/\s+/).map(segment => calculateMaxNestingLevel(segment)).filter(segment => segment);
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
        expect(parseNestedParens(inputText)).toEqual(analyzeParenthesesDepth(inputText))
    });
});