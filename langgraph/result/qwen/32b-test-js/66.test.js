// Source Code
function digitSum(s) {
    if (s === "") return 0;
    return [...s].reduce((sum, char) => char >= 'A' && char <= 'Z' ? sum + char.charCodeAt(0) : sum, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateUppercaseAsciiSum(inputString) {
    if (inputString === "") {
        return 0;
    }
    
    let total = 0;
    for (let i = 0; i < inputString.length; i++) {
        const character = inputString[i];
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