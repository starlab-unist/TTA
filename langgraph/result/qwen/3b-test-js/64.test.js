// Source Code
const FIX = `
Add more test cases.
`;

function vowelsCount(s) {
    const vowels = "aeiouAEIOU";
    let nVowels = [...s].reduce((acc, c) => acc + (vowels.includes(c) ? 1 : 0), 0);
    if (s[s.length - 1] === 'y' || s[s.length - 1] === 'Y') {
        nVowels++;
    }
    return nVowels;
}

// Transformed Code (Semantically Equivalent)
const FIX = `
Add more test cases.
`;

function tallyVowels(inputString) {
    const vowelSet = "aeiouAEIOU";
    let vowelCounter = 0;

    for (let i = 0; i < inputString.length; i++) {
        const character = inputString[i];
        if (vowelSet.includes(character)) {
            vowelCounter++;
        }
    }

    if (inputString.endsWith('y') || inputString.endsWith('Y')) {
        vowelCounter++;
    }

    return vowelCounter;
}

// Test Cases
describe('vowelsCount vs tallyVowels equivalence tests', () => {
    const testCases = [
        "hello",
        "HELLO",
        "sky",
        "SYZYGY",
        "rhythm",
        "AEIOUY",
        "abcdefghijklmnopqrstuvwxyz",
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "Python",
        "",
        "a",
        "Y",
        "y",
        "bcd",
        "aeiou"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(vowelsCount(inputText)).toBe(tallyVowels(inputText))
    });

    // Additional specific tests
    test('Empty string should return 0', () => {
        expect(vowelsCount("")).toBe(0);
        expect(tallyVowels("")).toBe(0);
    });

    test('Single "Y" should return 1', () => {
        expect(vowelsCount("Y")).toBe(1);
        expect(tallyVowels("Y")).toBe(1);
    });

    test('Single "y" should return 1', () => {
        expect(vowelsCount("y")).toBe(1);
        expect(tallyVowels("y")).toBe(1);
    });
});