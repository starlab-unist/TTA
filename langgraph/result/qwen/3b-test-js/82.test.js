// Source Code
function primeLength(string) {
    const l = string.length;
    if (l === 0 || l === 1) {
        return false;
    }
    for (let i = 2; i < l; i++) {
        if (l % i === 0) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function checkPrimeStringLength(inputText) {
    const stringLength = inputText.length;
    if (stringLength < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < stringLength) {
        if (stringLength % divisor === 0) {
            return false;
        }
        divisor++;
    }
    return true;
}

// Test Cases
describe('primeLength vs checkPrimeStringLength equivalence tests', () => {
    const testCases = [
        "",
        "a",
        "ab",
        "abc",
        "abcd",
        "abcde",
        "abcdef",
        "abcdefgh",
        "abcdefghi",
        "abcdefghij"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(primeLength(inputText)).toBe(checkPrimeStringLength(inputText))
    });
});