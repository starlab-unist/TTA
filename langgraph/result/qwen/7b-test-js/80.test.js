// Source Code
function isHappy(s) {
    if (s.length < 3) {
        return false;
    }

    for (let i = 0; i <= s.length - 3; i++) {
        if (s[i] === s[i + 1] || s[i + 1] === s[i + 2] || s[i] === s[i + 2]) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
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
        "abc",       // happy
        "aabbcc",    // not happy
        "abac",      // happy
        "aaa",       // not happy
        "abcdefg",   // happy
        "a",         // not happy (less than 3 characters)
        "ab",        // not happy (less than 3 characters)
        "aab",       // not happy
        "abcabc",    // happy
        "aabbba"     // not happy
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(isHappy(inputText)).toBe(checkHappiness(inputText))
    });
});