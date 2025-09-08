// Source Code
function isPalindrome(str) {
    return str === str.split('').reverse().join('');
}

function makePalindrome(str) {
    if (!str) {
        return '';
    }

    let beginningOfSuffix = 0;

    while (!isPalindrome(str.substring(beginningOfSuffix))) {
        beginningOfSuffix++;
    }

    return str + str.substring(0, beginningOfSuffix).split('').reverse().join('');
}

// Transformed Code (Semantically Equivalent)
function checkPalindrome(sequence) {
    /** Determine if the provided sequence is a palindrome */
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
describe('isPalindrome vs checkPalindrome equivalence tests', () => {
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
    });
});

describe('makePalindrome vs constructPalindrome equivalence tests', () => {
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
        expect(makePalindrome(inputText)).toBe(constructPalindrome(inputText));
    });
});