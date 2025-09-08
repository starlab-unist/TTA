// Source Code
function encode(message) {
    const vowels = 'aeiouAEIOU';
    const vowelsReplace = {};
    for (const vowel of vowels) {
        vowelsReplace[vowel] = String.fromCharCode(vowel.charCodeAt(0) + 2);
    }
    message = message.split('').map(char => char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase()).join('');
    return Array.from(message).map(char => vowels.includes(char) ? vowelsReplace[char] : char).join('');
}

// Transformed Code (Semantically Equivalent)
function transformMessage(inputText) {
    const vowelSet = "aeiouAEIOU";
    const vowelMapping = {};
    for (const char of vowelSet) {
        vowelMapping[char] = String.fromCharCode(char.charCodeAt(0) + 2);
    }
    const modifiedText = inputText.split('').map(char => char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase()).join('');
    let result = '';
    for (const char of modifiedText) {
        result += vowelMapping[char] || char;
    }
    return result;
}

// Test Cases
describe('encode vs transformMessage equivalence tests', () => {
    const testCases = [
        "Hello World",
        "Python Programming",
        "OpenAI",
        "encode",
        "AEIOUaeiou",
        "1234567890",
        "Symbols #$%^&*()",
        "Mixed CASE",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        ""
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(encode(inputText)).toBe(transformMessage(inputText))
    });
});