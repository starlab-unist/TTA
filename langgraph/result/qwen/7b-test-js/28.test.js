// Source Code
function concatenate(strings) {
    return strings.join('');
}

// Transformed Code (Semantically Equivalent)
function mergeStrings(string_list) {
    let result = "";
    let index = 0;
    while (index < string_list.length) {
        result += string_list[index];
        index += 1;
    }
    return result;
}

// Test Cases
describe('concatenate vs mergeStrings equivalence tests', () => {
    const testCases = [
        (["Hello", " ", "World"], "Hello World"),
        (["Python", "3.9"], "Python3.9"),
        ([], ""),
        (["single"], "single"),
        (["a", "b", "c", "d"], "abcd"),
        (["123", "456", "789"], "123456789"),
        (["space", " ", "between"], "space between"),
        (["no", "spaces"], "nospaces"),
        (["multiple", "   ", "spaces"], "multiple   spaces"),
        (["line1\n", "line2\n", "line3"], "line1\nline2\nline3")
    ];

    test.each(testCases)('Input: %j', ([input, expectedOutput]) => {
        expect(concatenate(input)).toBe(mergeStrings(input));
        expect(mergeStrings(input)).toBe(expectedOutput);
    });
});