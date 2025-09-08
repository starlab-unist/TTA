// Source Code
function countUpper(s) {
    let count = 0;
    for (let i = 0; i < s.length; i += 2) {
        if ("AEIOU".includes(s[i])) {
            count += 1;
        }
    }
    return count;
}

// Transformed Code (Semantically Equivalent)
function tallyEvenIndexVowels(inputString) {
    let vowelCount = 0;
    let index = 0;
    while (index < inputString.length) {
        if (index % 2 === 0 && "AEIOU".includes(inputString[index])) {
            vowelCount += 1;
        }
        index += 1;
    }
    return vowelCount;
}

// Test Cases
describe('countUpper vs tallyEvenIndexVowels equivalence tests', () => {
    const testCases = [
        ["", 0],
        ["A", 1],
        ["B", 0],
        ["AEIOU", 3],
        ["aeiou", 0],
        ["AbEcIdOfUg", 2],
        ["abcdefgHIJKL", 0],
        ["HELLOworld", 1],
        ["Python", 0],
        ["UPPERlower", 1],
        ["AEIOU" * 5, 8],  // "AEIOUAEIOUAEIOUAEIOUAEIOU"
        ["AxBxCxDxExF", 3]
    ];

    test.each(testCases)('Input: "%s"', (inputText, expectedOutput) => {
        expect(countUpper(inputText)).toBe(tallyEvenIndexVowels(inputText));
        expect(tallyEvenIndexVowels(inputText)).toBe(expectedOutput);
    });
});