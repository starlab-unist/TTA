// Source Code
function encodeCyclic(s) {
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    // Split string into groups. Each of length 3.
    const groups = [];
    for (let i = 0; i < Math.ceil(s.length / 3); i++) {
        groups.push(s.substring(i * 3, Math.min((i * 3 + 3), s.length)));
    }
    // Cycle elements in each group. Unless group has fewer elements than 3.
    for (let i = 0; i < groups.length; i++) {
        if (groups[i].length === 3) {
            groups[i] = groups[i].substring(1) + groups[i][0];
        }
    }
    return groups.join('');
}

function decodeCyclic(s) {
    return encodeCyclic(encodeCyclic(s));
}

// Transformed Code (Semantically Equivalent)
/**
 * Returns encoded string by cycling groups of three characters.
 * @param {string} inputString 
 * @returns {string}
 */
function transformCyclicString(inputString) {
    // Divide the string into chunks of three characters
    const chunks = [];
    for (let i = 0; i < inputString.length; i += 3) {
        chunks.push(inputString.substring(i, i + 3));
    }

    // Rotate each chunk if it contains exactly three characters
    const rotatedChunks = chunks.map(chunk => {
        return chunk.length === 3 ? chunk.slice(1) + chunk[0] : chunk;
    });

    // Join all chunks back into a single string
    return rotatedChunks.join('');
}

/**
 * Decodes the cyclically transformed string.
 * @param {string} encodedString 
 * @returns {string}
 */
function reverseCyclicTransformation(encodedString) {
    // Apply the transformation twice to decode the string
    return transformCyclicString(transformCyclicString(encodedString));
}

// Test Cases
describe('encodeCyclic and transformCyclicString equivalence', () => {
    const testCases = [
        "abcdef",
        "hello world",
        "abcde",
        "a",
        "",
        "python",
        "123456789",
        "transform",
        "cyclic",
        "unittest"
    ];

    testCases.forEach((testCase, index) => {
        it(`should produce the same result for encodeCyclic and transformCyclicString for test case ${index}`, () => {
            expect(encodeCyclic(testCase)).toEqual(transformCyclicString(testCase));
        });
    });
});

describe('decodeCyclic and reverseCyclicTransformation equivalence', () => {
    const testCases = [
        "abcdef",
        "hello world",
        "abcde",
        "a",
        "",
        "python",
        "123456789",
        "transform",
        "cyclic",
        "unittest"
    ];

    testCases.forEach((testCase, index) => {
        it(`should produce the same result for decodeCyclic and reverseCyclicTransformation for test case ${index}`, () => {
            expect(decodeCyclic(testCase)).toEqual(reverseCyclicTransformation(testCase));
        });
    });
});