// Source Code
function countDistinctCharacters(string) {
    return new Set(string.toLowerCase()).size;
}

// Transformed Code (Semantically Equivalent)
function determineUniqueCharCount(inputText) {
    const uniqueChars = new Set(inputText.toLowerCase());
    return uniqueChars.size;
}

// Test Cases
describe('countDistinctCharacters vs determineUniqueCharCount equivalence tests', () => {
    const testCases = [
        "Hello",
        "Python",
        "OpenAI",
        "AaBbCc",
        "1234567890",
        "!@#$%^&*()",
        "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz",
        "The quick brown fox jumps over the lazy dog",
        "",
        " ",
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(countDistinctCharacters(inputText)).toBe(determineUniqueCharCount(inputText));
    });
});