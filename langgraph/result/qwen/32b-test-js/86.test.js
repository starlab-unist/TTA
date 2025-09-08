// Source Code
function antiShuffle(s) {
    return s.split(' ').map(word => word.split('').sort().join('')).join(' ');
}

// Transformed Code (Semantically Equivalent)
function orderWordsCharacters(inputString) {
    const result = [];
    const words = inputString.split(' ');
    for (const word of words) {
        const sortedWord = word.split('').sort().join('');
        result.push(sortedWord);
    }
    return result.join(' ');
}

// Test Cases
describe('antiShuffle vs orderWordsCharacters equivalence tests', () => {
    const testCases = [
        "hello world",
        "python is fun",
        "openai gpt",
        "shuffle this string",
        "keep it sorted",
        "characters in words",
        "simple test case",
        "another example here",
        "singleword",
        ""
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(antiShuffle(inputText)).toBe(orderWordsCharacters(inputText))
    });
});