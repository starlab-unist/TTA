// Source Code
function reverseDelete(s, c) {
    s = s.split('').filter(char => !c.includes(char)).join('');
    return [s, s === s.split('').reverse().join('')];
}

console.log(reverseDelete("hello", "l")); // Output: ["heo", false]

// Transformed Code (Semantically Equivalent)
function reverseDelete(inputString, charsToRemove) {
    const filteredString = inputString.split('').filter(character => !charsToRemove.includes(character)).join('');
    const isPalindrome = filteredString === filteredString.split('').reverse().join('');
    return [filteredString, isPalindrome];
}

// Test Cases
describe('reverseDelete vs reverseDelete equivalence tests', () => {
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
        expect(reverseDelete(inputString, charsToRemove)).toBe(
            reverseDelete(inputString, charsToRemove)
        );
    });

    // More specific comparison using toEqual for array outputs
    testCases.forEach(([inputString, charsToRemove], index) => {
        test(`Test case ${index}`, () => {
            expect(reverseDelete(inputString, charsToRemove)).toEqual(
                reverseDelete(inputString, charsToRemove)
            );
        });
    });
});