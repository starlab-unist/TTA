// Source Code
function separateParenGroups(parenString) {
    let result = [];
    let currentString = [];
    let currentDepth = 0;

    for (let c of parenString) {
        if (c === '(') {
            currentDepth++;
            currentString.push(c);
        } else if (c === ')') {
            currentDepth--;
            currentString.push(c);

            if (currentDepth === 0) {
                result.push(currentString.join(''));
                currentString = [];
            }
        }
    }

    return result;
}

// Transformed Code (Semantically Equivalent)
function extractBalancedParentheses(inputSequence) {
    const outputGroups = [];
    let tempGroup = [];
    let nestingLevel = 0;

    let index = 0;
    while (index < inputSequence.length) {
        const character = inputSequence[index];
        if (character === '(') {
            nestingLevel++;
            tempGroup.push(character);
        } else if (character === ')') {
            nestingLevel--;
            tempGroup.push(character);

            if (nestingLevel === 0) {
                outputGroups.push(tempGroup.join(''));
                tempGroup = [];
            }
        }

        index++;
    }

    return outputGroups;
}

// Test Cases
describe('separateParenGroups vs extractBalancedParentheses equivalence tests', () => {
    const testCases = [
        "()",
        "(())",
        "((()))",
        "(()())",
        "()(())",
        "(()(()))",
        "",
        "a(b)c(d(e)f)g",
        "(abc)(def)",
        "((a)(b))(c)"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(separateParenGroups(inputText)).toEqual(extractBalancedParentheses(inputText))
    });
});