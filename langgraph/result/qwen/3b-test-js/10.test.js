// Source Code
function isPalindrome(string) {
    return string === string.split('').reverse().join('');
}

function makePalindrome(string) {
    if (!string) {
        return '';
    }

    let beginningOfSuffix = 0;

    while (!isPalindrome(string.substring(beginningOfSuffix))) {
        beginningOfSuffix++;
    }

    return string + string.substring(0, beginningOfSuffix).split('').reverse().join('');
}

// Transformed Code (Semantically Equivalent)
function checkPalindrome(sequence) {
    return sequence === sequence.split('').reverse().join('');
}

function constructPalindrome(inputStr) {
    if (!inputStr) {
        return '';
    }

    let suffixStartIndex = 0;

    while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
        suffixStartIndex++;
    }

    return inputStr + inputStr.substring(0, suffixStartIndex).split('').reverse().join('');
}

// Test Cases
describe('isPalindrome vs checkPalindrome and makePalindrome vs constructPalindrome equivalence tests', () => {
    const testCases = [
        "racecar",
        "hello",
        "",
        "a",
        "abba",
        "abcba",
        "abc",
        "noon",
        "level",
        "deified"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(isPalindrome(inputText)).toBe(checkPalindrome(inputText));
        expect(makePalindrome(inputText)).toBe(constructPalindrome(inputText));
    });
});