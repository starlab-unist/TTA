// Source Code
function isNested(string) {
    let openingBracketIndex = [];
    let closingBracketIndex = [];
    for (let i = 0; i < string.length; i++) {
        if (string[i] === '[') {
            openingBracketIndex.push(i);
        } else {
            closingBracketIndex.push(i);
        }
    }
    closingBracketIndex.reverse();
    let cnt = 0;
    let i = 0;
    let l = closingBracketIndex.length;
    for (let idx of openingBracketIndex) {
        if (i < l && idx < closingBracketIndex[i]) {
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
        index += 1;
    }
    endBracketsPositions.reverse();
    let matchCount = 0;
    let j = 0;
    const totalEndBrackets = endBracketsPositions.length;
    for (const openPos of startBracketsPositions) {
        if (j < totalEndBrackets && openPos < endBracketsPositions[j]) {
            matchCount += 1;
            j += 1;
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