// Source Code
function encodeCyclic(s) {
    const groups = s.match(/.{1,3}/g);
    return groups.map(group => group.length === 3 ? group.slice(1) + group[0] : group).join('');
}

function decodeCyclic(s) {
    return encodeCyclic(encodeCyclic(s));
}

// Transformed Code (Semantically Equivalent)
function transformCyclicString(inputString) {
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    // Divide the string into chunks of three characters
    const chunks = inputString.match(/.{1,3}/g);

    // Rotate each chunk if it contains exactly three characters
    const rotatedChunks = chunks.map(chunk => {
        return chunk.length === 3 ? chunk.slice(1) + chunk[0] : chunk;
    });

    // Join all chunks back into a single string
    return rotatedChunks.join('');
}

function reverseCyclicTransformation(encodedString) {
    // Apply the transformation twice to decode the string
    return transformCyclicString(transformCyclicString(encodedString));
}

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

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(encodeCyclic(inputText)).toBe(transformCyclicString(inputText));
    });
});

describe('decodeCyclic vs reverseCyclicTransformation equivalence tests', () => {
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

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(decodeCyclic(inputText)).toBe(reverseCyclicTransformation(inputText));
    });
});