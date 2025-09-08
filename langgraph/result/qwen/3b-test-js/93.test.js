// Source Code
function encode(message) {
    const vowels = "aeiouAEIOU";
    const vowelsReplace = new Map([...vowels].map((i) => [i, String.fromCharCode(i.charCodeAt(0) + 2)]));
    message = message.split('').map(char => vowelsReplace.get(char) || char).join('');
    return message;
}

// Transformed Code (Semantically Equivalent)
function transformMessage(inputText) {
    const vowelSet = "aeiouAEIOU";
    const vowelMapping = new Map([...vowelSet].map(char => [char, String.fromCharCode(char.charCodeAt(0) + 2)]));
    let result = '';
    for (let char of inputText) {
        result += vowelMapping.get(char) || char;
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
        expect(encode(inputText)).toBe(transformMessage(inputText));
    });
});