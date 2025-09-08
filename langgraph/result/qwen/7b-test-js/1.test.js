// Source Code
function separateParenGroups(parenString) {
    const result = [];
    let currentString = '';
    let currentDepth = 0;

    for (let i = 0; i < parenString.length; i++) {
        const c = parenString[i];
        if (c === '(') {
            currentDepth += 1;
            currentString += c;
        } else if (c === ')') {
            currentDepth -= 1;
            currentString += c;

            if (currentDepth === 0) {
                result.push(currentString);
                currentString = '';
            }
        }
    }

    return result;
}

// Transformed Code (Semantically Equivalent)
function extractBalancedParentheses(parenString) {
    let outputGroups = [];
    let tempGroup = [];
    let nestingLevel = 0;
    let index = 0;

    while (index < parenString.length) {
        let character = parenString[index];
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