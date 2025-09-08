// Source Code
function removeVowels(text) {
    return text.split('').filter(s => !'aeiouAEIOU'.includes(s)).join('');
}

// Transformed Code (Semantically Equivalent)
function stripVowels(inputString) {
    const vowels = new Set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']);
    let result = [];
    let index = 0;

    while (index < inputString.length) {
        const char = inputString[index];
        if (!vowels.has(char)) {
            result.push(char);
        }
        index++;
    }

    return result.join('');
}

// Test Cases
describe('removeVowels vs stripVowels equivalence tests', () => {
    const testCases = [
        "Hello, World!",
        "Python Programming",
        "AEIOUaeiou",
        "abcdefghijklmnopqrstuvwxyz",
        "THE quick brown fox JUMPS over the LAZY dog",
        "1234567890",
        "!@#$%^&*()_+",
        "OpenAI",
        "a b c d e f g h i j",
        "This is a simple test case."
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(removeVowels(inputText)).toBe(stripVowels(inputText))
    });
});