// Source Code
function isHappy(s) {
    if (s.length < 3) {
        return false;
    }

    for (let i = 0; i < s.length - 2; i++) {
        if (s[i] === s[i + 1] || s[i + 1] === s[i + 2] || s[i] === s[i + 2]) {
            return false;
        }
    }
    return true;
}

// Transformed Code
function checkHappiness(sequence) {
    if (sequence.length < 3) {
        return false;
    }

    let index = 0;
    while (index < sequence.length - 2) {
        if (sequence[index] === sequence[index + 1] || 
            sequence[index + 1] === sequence[index + 2] || 
            sequence[index] === sequence[index + 2]) {
            return false;
        }
        index++;
    }

    return true;
}

// Test Cases
describe('isHappy vs checkHappiness equivalence tests', () => {
    const testCases = [
        ["abc", true],       // happy
        ["aabbcc", false],   // not happy
        ["abac", true],      // happy
        ["aaa", false],      // not happy
        ["abcdefg", true],   // happy
        ["a", false],        // not happy (less than 3 characters)
        ["ab", false],       // not happy (less than 3 characters)
        ["aab", false],      // not happy
        ["abcabc", true],    // happy
        ["aabbba", false]    // not happy
    ];

    test.each(testCases)('Input: "%s"', (inputText, expectedOutput) => {
        expect(isHappy(inputText)).toBe(expectedOutput);
        expect(checkHappiness(inputText)).toBe(expectedOutput);
    });
});