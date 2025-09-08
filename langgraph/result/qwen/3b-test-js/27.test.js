// Source Code
function flipCase(string) {
    return string.toUpperCase();
}

// Transformed Code (Semantically Equivalent)
function invertCharacterCase(inputText) {
    let result = '';
    for (let char of inputText) {
        if (char === char.toLowerCase()) {
            result += char.toUpperCase();
        } else if (char === char.toUpperCase()) {
            result += char.toLowerCase();
        } else {
            result += char;
        }
    }
    return result;
}

console.log(invertCharacterCase("Alice"));

// Test Cases
describe('flipCase vs invertCharacterCase equivalence tests', () => {
    const testCases = [
        "Hello World",
        "Python3.8",
        "1234567890",
        "FLIPCASEflipcase",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "!@#$%^&*()_+",
        "ALLCAPS",
        "alllower",
        "MiXeD CaSe",
        ""
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(flipCase(inputText)).toBe(invertCharacterCase(inputText))
    });
});