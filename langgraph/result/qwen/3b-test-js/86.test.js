// Source Code
function anti_shuffle(s) {
    return s.split(' ').map(i => [...i].sort().join('')).join(' ');
}

// Transformed Code (Semantically Equivalent)
function orderWordsCharacters(inputString) {
    let result = [];
    for (let word of inputString.split(' ')) {
        let sortedWord = word.split('').sort().join('');
        result.push(sortedWord);
    }
    return result.join(' ');
}

// Test Cases
describe('anti_shuffle vs orderWordsCharacters equivalence tests', () => {
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
        expect(anti_shuffle(inputText)).toBe(orderWordsCharacters(inputText));
    });
});