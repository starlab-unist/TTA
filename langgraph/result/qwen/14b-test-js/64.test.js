// Source Code
const FIX = `
Add more test cases.
`;

function vowelsCount(s) {
    const vowels = "aeiouAEIOU";
    let nVowels = 0;
    for (let c of s) {
        if (vowels.includes(c)) {
            nVowels++;
        }
    }
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

    for (let character of inputString) {
        if (vowelSet.includes(character)) {
            vowelCounter += 1;
        }
    }

    if (inputString.endsWith('y') || inputString.endsWith('Y')) {
        vowelCounter += 1;
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

    test('Empty string', () => {
        expect(vowelsCount("")).toBe(0);
    });

    test('Single "a"', () => {
        expect(vowelsCount("a")).toBe(1);
    });

    test('Single "Y" uppercase', () => {
        expect(vowelsCount("Y")).toBe(1);
    });

    test('Single "y" lowercase', () => {
        expect(vowelsCount("y")).toBe(1);
    });
});