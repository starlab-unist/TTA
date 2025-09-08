// Source Code
function findMax(words) {
    return words.sort((a, b) => {
        const uniqueA = new Set(a).size;
        const uniqueB = new Set(b).size;
        if (uniqueA === uniqueB) {
            return a.localeCompare(b);
        }
        return uniqueB - uniqueA;
    })[0];
}

// Transformed Code (Semantically Equivalent)
function determineLongestUniqueCharString(wordList) {
    function customSortKey(word) {
        const uniqueChars = new Set(word).size;
        return [-uniqueChars, word];
    }
    
    const sortedWords = wordList.sort((a, b) => {
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

    test.each(testCases)('Input: %p', (inputWords) => {
        expect(findMax(inputWords)).toBe(determineLongestUniqueCharString(inputWords));
    });
});