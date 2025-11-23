function filterBySubstring(strings, substring) {
    return strings.filter(x => x.includes(substring));
}

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

describe('filterBySubstring vs extractMatchingStrings equivalence tests', () => {
    const testCases = [
        [["hello", "world", "hello world"], "hello"],
        [["abc", "def", "xyz"], "a"],
        [["123", "456", "789"], "1"],
        [["", "a", "b"], "a"],
        [["apple", "banana", "cherry"], "an"],
        [["test", "text", "taste"], "t"],
        [["UPPER", "lower", "Mixed"], "lower"],
        [["empty", "list", "without match"], "xyz"],
        [["a", "aa", "aaa"], "a"],
        [["Case", "case", "CASE"], "case"]
    ];

    test.each(testCases)('Input array: %p, substring: %p', ([strings, substring]) => {
        expect(filterBySubstring(strings, substring)).toEqual(extractMatchingStrings(strings, substring));
    });
});