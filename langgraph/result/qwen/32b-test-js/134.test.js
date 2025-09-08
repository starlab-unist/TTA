// Source Code
function checkIfLastCharIsALetter(txt) {
    const words = txt.split(' ');
    const check = words[words.length - 1];
    return check.length === 1 && /^[a-z]$/i.test(check);
}

// Transformed Code (Semantically Equivalent)
function determineIfFinalCharacterIsAlphabetic(inputString) {
    const lastWord = inputString.split(' ').pop();
    return lastWord.length === 1 && /[a-z]/i.test(lastWord);
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