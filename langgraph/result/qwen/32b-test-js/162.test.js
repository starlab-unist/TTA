// Source Code
function stringToMd5(text) {
    if (!text) return null;
    const encoder = new TextEncoder();
    const data = encoder.encode(text);
    return crypto.subtle.digest('MD5', data).then(hashBuffer => {
        const hashArray = Array.from(new Uint8Array(hashBuffer));
        const hashHex = hashArray.map(byte => byte.toString(16).padStart(2, '0')).join('');
        return hashHex;
    });
}

// Transformed Code (Semantically Equivalent)
const crypto = require('crypto');

function convertTextToHash(inputString) {
    if (!inputString) {
        return null;
    }
    const encodedString = Buffer.from(inputString, 'ascii');
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

    test.each(testCases)('Input: "%s"', async (inputText) => {
        const originalResult = await stringToMd5(inputText);
        const transformedResult = convertTextToHash(inputText);
        expect(originalResult).toBe(transformedResult);
    });
});