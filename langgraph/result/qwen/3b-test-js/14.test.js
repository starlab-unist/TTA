// Source Code
function allPrefixes(string) {
    let result = [];

    for (let i = 0; i < string.length; i++) {
        result.push(string.substring(0, i + 1));
    }

    return result;
}

// Transformed Code (Semantically Equivalent)
function generateStringPrefixes(inputStr) {
    let prefixes = [];
    let index = 0;

    while (index < inputStr.length) {
        prefixes.push(inputStr.substring(0, index + 1));
        index++;
    }

    return prefixes;
}

// Test Cases
describe('allPrefixes vs generateStringPrefixes equivalence tests', () => {
    const testCases = [
        "hello",
        "world",
        "a",
        "",
        "python",
        "unittest",
        "12345",
        "prefixes",
        "testcase",
        "semantics"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(allPrefixes(inputText)).toBe(generateStringPrefixes(inputText));
    });
});