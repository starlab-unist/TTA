// Source Code
function filterBySubstring(strings, substring) {
    return strings.filter(x => x.includes(substring));
}

// Transformed Code (Semantically Equivalent)
function extractMatchingStrings(sequence, pattern) {
    const result = [];
    let index = 0;
    while (index < sequence.length) {
        if (sequence[index].includes(pattern)) {
            result.push(sequence[index]);
        }
        index += 1;
    }
    return result;
}

// Test Cases
describe('filterBySubstring vs extractMatchingStrings equivalence tests', () => {
    const testCases = [
        (["hello", "world", "help"], "he"),
        (["apple", "banana", "cherry"], "a"),
        (["one", "two", "three"], "four"),
        ([], "test"),
        (["abc", "def", "ghi"], ""),
        (["123", "456", "789"], "5"),
        (["repeat", "repeal", "replace"], "rep"),
        (["same", "same", "same"], "s"),
        (["unique"], "uni"),
        (["different", "words", "here"], "word")
    ];

    test.each(testCases)('Input: %j, "%s"', (inputStrings, inputSubstring) => {
        expect(filterBySubstring(inputStrings, inputSubstring)).toBe(extractMatchingStrings(inputStrings, inputSubstring))
    });
});