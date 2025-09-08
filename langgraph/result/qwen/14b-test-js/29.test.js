// Source Code
function filterByPrefix(strings, prefix) {
    return strings.filter(x => x.startsWith(prefix));
}

// Transformed Code (Semantically Equivalent)
function selectStringsStartingWithChars(wordList, startSequence) {
    const filteredWords = [];
    for (const word of wordList) {
        if (word.startsWith(startSequence)) {
            filteredWords.push(word);
        }
    }
    return filteredWords;
}

// Test Cases
describe('filterByPrefix vs selectStringsStartingWithChars equivalence tests', () => {
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

    test.each(testCases)('Input: %j, Prefix: "%s"', (inputArray, inputPrefix) => {
        expect(filterByPrefix(inputArray, inputPrefix)).toEqual(selectStringsStartingWithChars(inputArray, inputPrefix));
    });
});