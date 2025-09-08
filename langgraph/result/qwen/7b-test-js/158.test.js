// Source Code
function findMax(words) {
    return words.sort((a, b) => {
        const lenA = new Set(a).size;
        const lenB = new Set(b).size;
        if (lenA !== lenB) {
            return lenB - lenA;
        }
        return a.localeCompare(b);
    })[0];
}

// Transformed Code (Semantically Equivalent)
function determineLongestUniqueCharString(words) {
    function customSortKey(word) {
        const uniqueChars = new Set(word);
        return [-uniqueChars.size, word];
    }

    const sortedWords = words.sort((a, b) => {
        const keyA = customSortKey(a);
        const keyB = customSortKey(b);
        
        if (keyA[0] !== keyB[0]) {
            return keyA[0] - keyB[0];
        }
        return keyA[1].localeCompare(keyB[1]);
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