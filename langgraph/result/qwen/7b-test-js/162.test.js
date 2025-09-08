// Source Code
function stringToMd5(text) {
    if (!text) return null;
    const crypto = require('crypto');
    return crypto.createHash('md5').update(text).digest('hex');
}

// Transformed Code (Semantically Equivalent)
const crypto = require('crypto');

function convertTextToHash(text) {
    if (!text) {
        return null;
    }
    const encodedString = Buffer.from(text, 'utf-8');
    const md5Hash = crypto.createHash('md5').update(encodedString).digest('hex');
    return md5Hash;
}

// Test Cases
describe('stringToMd5 vs convertTextToHash equivalence tests', () => {
    const testCases = [
        "Hello, World!",
        "OpenAI",
        "Python is fun!",
        "1234567890",
        "",
        "a",
        "MD5 hash",
        "unittest",
        "transformed code",
        "semantically equivalent"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(stringToMd5(inputText)).toBe(convertTextToHash(inputText))
    });
});