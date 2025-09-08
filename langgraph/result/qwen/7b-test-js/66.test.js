// Source Code
function digitSum(s) {
    if (s === "") return 0;
    return [...s].reduce((sum, char) => {
        if (char >= 'A' && char <= 'Z') {
            return sum + char.charCodeAt(0);
        }
        return sum;
    }, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateUppercaseAsciiSum(s) {
    if (s === "") {
        return 0;
    }
    
    let total = 0;
    for (let i = 0; i < s.length; i++) {
        const character = s[i];
        if (character >= 'A' && character <= 'Z') {
            total += character.charCodeAt(0);
        }
    }
    
    return total;
}

// Test Cases
describe('digitSum vs calculateUppercaseAsciiSum equivalence tests', () => {
    const testCases = [
        "",
        "abc",
        "ABC",
        "Hello World!",
        "Python3.8",
        "OpenAI",
        "1234567890",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "MIXeD CaSe 123",
        "UPPER lower"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(digitSum(inputText)).toBe(calculateUppercaseAsciiSum(inputText))
    });
});