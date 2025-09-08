// Source Code
function findMax(words) {
    return words.sort((a, b) => {
        const uniqueCharsA = new Set(a).size;
        const uniqueCharsB = new Set(b).size;
        if (uniqueCharsA !== uniqueCharsB) {
            return uniqueCharsB - uniqueCharsA;
        }
        return a.localeCompare(b);
    })[0];
}

// Transformed Code (Semantically Equivalent)
function determineLongestUniqueCharString(wordList) {
    function customSortKey(word) {
        return [-new Set(word).size, word];
    }

    const sortedWords = wordList.sort((a, b) => {
        const [lenA, strA] = customSortKey(a);
        const [lenB, strB] = customSortKey(b);
        if (lenA !== lenB) {
            return lenA - lenB;
        }
        return strA.localeCompare(strB);
    });

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