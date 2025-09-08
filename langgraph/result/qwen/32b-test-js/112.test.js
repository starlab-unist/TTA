// Source Code
function reverseDelete(s, c) {
    s = s.split('').filter(char => !c.includes(char)).join('');
    return [s, s === s.split('').reverse().join('')];
}

// Transformed Code (Semantically Equivalent)
function filterAndCheckPalindrome(inputString, charsToRemove) {
    const filteredString = [...inputString].filter(character => !charsToRemove.includes(character)).join('');
    const isPalindrome = filteredString === filteredString.split('').reverse().join('');
    return [filteredString, isPalindrome];
}

// Test Cases
describe('reverseDelete vs filterAndCheckPalindrome equivalence tests', () => {
    const testCases = [
        ["abcba", "x"],
        ["abccba", "x"],
        ["hello", "aeiou"],
        ["racecar", ""],
        ["palindrome", "xyz"],
        ["", "a"],
        ["aabbcc", "abc"],
        ["rotor", "r"],
        ["deified", "d"],
        ["noon", "n"]
    ];

    test.each(testCases)('Input: "%s", "%s"', (inputString, charsToRemove) => {
        expect(reverseDelete(inputString, charsToRemove)).toEqual(filterAndCheckPalindrome(inputString, charsToRemove))
    });
});