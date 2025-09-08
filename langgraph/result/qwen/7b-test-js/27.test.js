// Source Code
function flipCase(str) {
    return str.split('').map(char => char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase()).join('');
}

// Transformed Code (Semantically Equivalent)
function invertCharacterCase(inputText) {
    let result = '';
    for (let i = 0; i < inputText.length; i++) {
        let char = inputText[i];
        if (char >= 'a' && char <= 'z') {
            result += char.toUpperCase();
        } else if (char >= 'A' && char <= 'Z') {
            result += char.toLowerCase();
        } else {
            result += char;
        }
    }
    return result;
}

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