// Source Code
function encrypt(s) {
    const d = 'abcdefghijklmnopqrstuvwxyz';
    let out = '';
    for (let c of s) {
        if (d.includes(c)) {
            const index = d.indexOf(c);
            out += d[(index + 2 * 2) % 26];
        } else {
            out += c;
        }
    }
    return out;
}

console.log(encrypt("Alice"));

// Transformed Code (Semantically Equivalent)
function cipherText(inputString) {
    const alphabet = 'abcdefghijklmnopqrstuvwxyz';
    let result = [];
    for (let character of inputString) {
        if (alphabet.includes(character)) {
            const newIndex = (alphabet.indexOf(character) + 4) % 26;
            result.push(alphabet[newIndex]);
        } else {
            result.push(character);
        }
    }
    return result.join('');
}

// Test Cases
describe('encrypt vs cipherText equivalence tests', () => {
    const testCases = [
        "hello",
        "world",
        "abcxyz",
        "python",
        "12345",
        "!@#$%",
        "encrypt this string",
        "a quick brown fox jumps over the lazy dog",
        "the quick brown fox jumps over the lazy dog",
        "abcdefghijklmnopqrstuvwxyz"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(encrypt(inputText)).toBe(cipherText(inputText));
    });
});