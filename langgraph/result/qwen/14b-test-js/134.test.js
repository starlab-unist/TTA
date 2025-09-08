// Source Code
function checkIfLastCharIsALetter(txt) {
    const check = txt.split(' ').pop();
    return check.length === 1 && (check.toLowerCase().charCodeAt(0) >= 97 && check.toLowerCase().charCodeAt(0) <= 122);
}

// Transformed Code (Semantically Equivalent)
function determineIfFinalCharacterIsAlphabetic(inputString) {
    const lastWord = inputString.split(' ').pop();
    return lastWord.length === 1 && 'a' <= lastWord.toLowerCase() <= 'z';
}

// Test Cases
describe('checkIfLastCharIsALetter vs determineIfFinalCharacterIsAlphabetic equivalence tests', () => {
    const testCases = [
        "hello world a",
        "test z",
        "123 b",
        "c",
        "no letters here !",
        "singleword x",
        "spaces at the end ",
        "  leading spaces y",
        "",
        "onlyoneletter"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(checkIfLastCharIsALetter(inputText)).toBe(determineIfFinalCharacterIsAlphabetic(inputText))
    });
});