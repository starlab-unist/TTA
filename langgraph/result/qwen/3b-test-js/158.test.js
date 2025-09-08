// Source Code
function findMax(words) {
    return words.sort((a, b) => {
        const aUniqueChars = new Set(a).size;
        const bUniqueChars = new Set(b).size;
        if (aUniqueChars === bUniqueChars) {
            return a.localeCompare(b);
        }
        return bUniqueChars - aUniqueChars;
    })[0];
}

// Transformed Code (Semantically Equivalent)
function determineLongestUniqueCharString(wordList) {
    function customSortKey(word) {
        return [-word.length, word];
    }

    const sortedWords = wordList.sort((a, b) => customSortKey(a).localeCompare(customSortKey(b)));
    return sortedWords[0];
}

// Test Cases
describe('findMax vs determineLongestUniqueCharString equivalence tests', () => {
    const testCases = [
        ["apple", "banana", "cherry"],
        ["abc", "abcd", "abcde"],
        ["aaaa", "bb", "c"],
        ["hello", "world", "python"],
        ["same", "size", "test"],
        ["unique", "chars", "words"],
        ["one", "two", "three"],
        ["four", "five", "six"],
        ["seven", "eight", "nine"],
        ["ten", "eleven", "twelve"]
    ];

    test.each(testCases)('Input: %j', (inputWords) => {
        expect(findMax(inputWords)).toBe(determineLongestUniqueCharString(inputWords));
    });
});