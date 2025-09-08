// Source Code
function isPalindrome(text) {
    for (let i = 0; i < text.length; i++) {
        if (text[i] !== text[text.length - 1 - i]) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function checkPalindrome(sequence) {
    let index = 0;
    const length = sequence.length;
    
    while (index < length / 2) {
        if (sequence[index] !== sequence[length - index - 1]) {
            return false;
        }
        index++;
    }
    return true;
}

// Test Cases
describe('isPalindrome vs checkPalindrome equivalence tests', () => {
    const testCases = [
        "racecar",
        "level",
        "hello",
        "world",
        "",
        "a",
        "abba",
        "abcba",
        "noon",
        "python"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(isPalindrome(inputText)).toBe(checkPalindrome(inputText))
    });
});