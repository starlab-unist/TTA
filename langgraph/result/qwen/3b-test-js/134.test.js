// Source Code
function checkIfLastCharIsALetter(txt) {
    const words = txt.split(' ');
    const lastWord = words[words.length - 1];
    return lastWord.length === 1 && (lastWord.toLowerCase().charCodeAt(0) >= 97 && lastWord.toLowerCase().charCodeAt(0) <= 122);
}

// Transformed Code
function determineIfFinalCharacterIsAlphabetic(inputString) {
    const lastWord = inputString.split(' ').pop();
    return lastWord.length === 1 && 'a'.charCodeAt(0) <= lastWord.toLowerCase().charCodeAt(0) && lastWord.toLowerCase().charCodeAt(0) <= 'z'.charCodeAt(0);
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