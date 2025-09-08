// Source Code
function encodeCyclic(s) {
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    // Split string into groups of length 3.
    let groups = [];
    for (let i = 0; i < s.length; i += 3) {
        groups.push(s.slice(i, Math.min(i + 3, s.length)));
    }
    // Cycle elements in each group unless group has fewer than 3 elements.
    groups = groups.map(group => group.length === 3 ? group.slice(1) + group[0] : group);
    return groups.join('');
}

function decodeCyclic(s) {
    return encodeCyclic(encodeCyclic(s));
}

// Transformed Code (Semantically Equivalent)
/**
 * Returns encoded string by cycling groups of three characters.
 * @param {string} inputString - The string to be encoded.
 * @returns {string} - The encoded string.
 */
function transformCyclicString(inputString) {
    // Divide the string into chunks of three characters
    const chunks = [];
    for (let i = 0; i < inputString.length; i += 3) {
        chunks.push(inputString.substring(i, i + 3));
    }

    // Rotate each chunk if it contains exactly three characters
    const rotatedChunks = chunks.map(chunk => {
        if (chunk.length === 3) {
            return chunk.slice(1) + chunk.charAt(0);
        }
        return chunk;
    });

    // Join all chunks back into a single string
    return rotatedChunks.join('');
}

/**
 * Decodes the cyclically transformed string by applying the transformation twice.
 * @param {string} encodedString - The string to be decoded.
 * @returns {string} - The decoded string.
 */
function reverseCyclicTransformation(encodedString) {
    // Apply the transformation twice to decode the string
    return transformCyclicString(transformCyclicString(encodedString));
}

// Renamed methods and parameters as specified
// Used array methods like map and slice for transformations
// Added comments for clarity on each step

// Test Cases
describe('encodeCyclic vs transformCyclicString equivalence tests', () => {
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
        it(`Test case ${index}`, () => {
            expect(encodeCyclic(testCase)).toEqual(transformCyclicString(testCase));
        });
    });
});