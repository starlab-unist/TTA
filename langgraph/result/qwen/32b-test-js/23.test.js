// Source Code
function strlen(string) {
    return string.length;
}

// Transformed Code (Semantically Equivalent)
function calculateStringLength(text) {
    let count = 0;
    for (let character of text) {
        count += 1;
    }
    return count;
}

// Test Cases
describe('strlen vs calculateStringLength equivalence tests', () => {
    const testCases = [
        "",
        "a",
        "hello",
        "OpenAI",
        "1234567890",
        "!@#$%^&*()",
        "spaces in between",
        "repeated repeated repeated",
        "A quick brown fox jumps over the lazy dog",
        "Python unittest framework"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(strlen(inputText)).toBe(calculateStringLength(inputText));
    });
});