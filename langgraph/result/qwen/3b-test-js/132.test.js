// Source Code
function isNested(string) {
    const openingBracketIndices = [];
    const closingBracketIndices = [];

    for (let i = 0; i < string.length; i++) {
        if (string[i] === '[') {
            openingBracketIndices.push(i);
        } else {
            closingBracketIndices.push(i);
        }
    }

    closingBracketIndices.reverse();

    let cnt = 0;
    let i = 0;
    const l = closingBracketIndices.length;

    for (const idx of openingBracketIndices) {
        if (i < l && idx < closingBracketIndices[i]) {
            cnt += 1;
            i += 1;
        }
    }

    return cnt >= 2;
}

// Transformed Code (Semantically Equivalent)
function checkForNesting(expression) {
    const startBracketsPositions = [];
    const endBracketsPositions = [];
    let index = 0;

    while (index < expression.length) {
        if (expression[index] === '[') {
            startBracketsPositions.push(index);
        } else {
            endBracketsPositions.push(index);
        }
        index++;
    }

    endBracketsPositions.reverse();
    let matchCount = 0;
    let j = 0;
    const totalEndBrackets = endBracketsPositions.length;

    for (const openPos of startBracketsPositions) {
        if (j < totalEndBrackets && openPos < endBracketsPositions[j]) {
            matchCount++;
            j++;
        }
    }

    return matchCount >= 2;
}

// Test Cases
describe('isNested vs checkForNesting equivalence tests', () => {
    const testCases = [
        "[]",
        "[[]]",
        "[][]",
        "[[[]]]",
        "[[[[[]]]]]",
        "][",
        "[]][[]",
        "[[]][][[]]",
        "[[[[[]]]]],[[[]]]",
        "[[[]]][][][[[[]]]]"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(isNested(inputText)).toBe(checkForNesting(inputText));
    });
});