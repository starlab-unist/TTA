// Source Code
function checkIfLastCharIsALetter(txt) {
    const check = txt.split(' ').pop();
    return check.length === 1 && /^[a-zA-Z]$/.test(check);
}

// Transformed Code (Semantically Equivalent)
function transformed_checkIfLastCharIsALetter(txt) {
    const check = txt.split(' ').pop();
    return check.length === 1 && /^[a-z]$/i.test(check);
}

// Test Cases
describe('checkIfLastCharIsALetter vs transformed_checkIfLastCharIsALetter equivalence tests', () => {
    const testCases = [
        "hello world a",
        "test z",
        "123 b",
        "c",
        "no letters here !",
        "singleword x",
        "spaces at the end ",
        "  leading spaces y",
        "",
        "onlyoneletter"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(checkIfLastCharIsALetter(inputText)).toBe(transformed_checkIfLastCharIsALetter(inputText));
    });
});