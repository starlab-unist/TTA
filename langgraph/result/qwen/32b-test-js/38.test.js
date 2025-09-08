// Source Code
function encodeCyclic(s) {
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    // Split string into groups. Each of length 3.
    const groups = [];
    for (let i = 0; i < Math.ceil(s.length / 3); i++) {
        groups.push(s.substring(3 * i, Math.min(3 * i + 3, s.length)));
    }
    // Cycle elements in each group. Unless group has fewer elements than 3.
    const cycledGroups = groups.map(group => 
        group.length === 3 ? group.slice(1) + group[0] : group
    );
    return cycledGroups.join('');
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
    const chunks = [];
    for (let i = 0; i < inputString.length; i += 3) {
        chunks.push(inputString.substring(i, i + 3));
    }
    
    // Rotate each chunk if it contains exactly three characters
    const rotatedChunks = chunks.map(chunk => chunk.length === 3 ? chunk.slice(1) + chunk[0] : chunk);
    
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

    describe('decodeCyclic vs reverseCyclicTransformation equivalence tests', () => {
        const encodedTestCases = testCases.map((testCase) => encodeCyclic(testCase));

        test.each(encodedTestCases)('Encoded Input: "%s"', (encodedInput) => {
            expect(decodeCyclic(encodedInput)).toBe(reverseCyclicTransformation(encodedInput));
        });
    });
});