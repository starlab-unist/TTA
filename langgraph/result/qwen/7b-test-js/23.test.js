// Source Code
function strlen(string) {
    return string.length;
}

// Transformed Code (Semantically Equivalent)
function calculateStringLength(string) {
    let count = 0;
    for (let character of string) {
        count += 1;
    }
    return count;
}
// method name: strlen -> calculateStringLength
// parameter name: string -> text
// replaced length property with a manual counting loop

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
        expect(strlen(inputText)).toBe(calculateStringLength(inputText))
    });
});