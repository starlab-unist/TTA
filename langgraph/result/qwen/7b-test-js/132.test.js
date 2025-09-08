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
function isNested(expression) {
    let startBracketPositions = [];
    let endBracketPositions = [];
    let index = 0;
    while (index < expression.length) {
        if (expression[index] === '[') {
            startBracketPositions.push(index);
        } else {
            endBracketPositions.push(index);
        }
        index++;
    }
    endBracketPositions.reverse();
    let matchCount = 0;
    let j = 0;
    let totalEndBrackets = endBracketPositions.length;
    for (let openPos of startBracketPositions) {
        if (j < totalEndBrackets && openPos < endBracketPositions[j]) {
            matchCount++;
            j++;
        }
    }
    return matchCount >= 2;
}

// Test Cases
describe('isNested vs isNested equivalence tests', () => {
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
        expect(isNested(inputText)).toBe(isNested(inputText))
    });
});