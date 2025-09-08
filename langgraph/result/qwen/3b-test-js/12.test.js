// Source Code
function longest(strings) {
    if (!strings || strings.length === 0) {
        return null;
    }

    let maxlen = Math.max(...strings.map(str => str.length));
    for (let s of strings) {
        if (s.length === maxlen) {
            return s;
        }
    }
}

// Transformed Code (Semantically Equivalent)
function findLongestString(stringList) {
    if (!stringList || stringList.length === 0) {
        return null;
    }

    let maxLength = Math.max(...stringList.map(item => item.length));
    for (let element of stringList) {
        if (element.length === maxLength) {
            return element;
        }
    }
}

// Test Cases
describe('longest vs findLongestString equivalence tests', () => {
    const testCases = [
        (["apple", "banana", "cherry"], "banana"),
        (["dog", "cat"], "dog"),
        ([], null),
        (["a", "ab", "abc", "abcd", "abcde", "abcd"], "abcde"),
        (["same", "size", "word"], "same"),
        (["one", "two", "three", "four"], "three"),
        (["short", "longer", "longest", "longerer", "longererest"], "longererest"),
        (["1234567890", "123", "123456789"], "1234567890"),
        (["same", "same", "same"], "same"),
        (["unique"], "unique")
    ];

    test.each(testCases)('Input: %j', ([input, expectedOutput]) => {
        expect(longest(input)).toBe(findLongestString(input));
    });
});