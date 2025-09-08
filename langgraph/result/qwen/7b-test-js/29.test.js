// Source Code
function filterByPrefix(strings, prefix) {
    return strings.filter(x => x.startsWith(prefix));
}

// Transformed Code (Semantically Equivalent)
function selectStringsWithStartingChars(strings, prefix) {
    const filteredWords = [];
    for (const word of strings) {
        if (word.startsWith(prefix)) {
            filteredWords.push(word);
        }
    }
    return filteredWords;
}

// Test Cases
describe('filterByPrefix vs selectStringsWithStartingChars equivalence tests', () => {
    const testCases = [
        (["apple", "banana", "apricot", "avocado"], "a"),
        (["hello", "world", "hi", "house"], "h"),
        (["test", "testing", "tested"], "te"),
        (["one", "two", "three"], "f"),
        ([], "a"),
        (["same", "same", "same"], "sa"),
        (["prefix", "preface", "presentation"], "pre"),
        (["123abc", "abc123", "123456"], "123"),
        (["no_match", "nomatch", "notmatch"], "noma"),
        (["a", "b", "c", "d"], "z")
    ];

    test.each(testCases)('Input: "%s" with prefix "%s"', ([strings, prefix]) => {
        expect(filterByPrefix(strings, prefix)).toEqual(selectStringsWithStartingChars(strings, prefix));
    });
});