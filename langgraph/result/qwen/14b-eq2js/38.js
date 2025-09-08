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

// method name: encode_cyclic -> transformCyclicString
// method name: decode_cyclic -> reverseCyclicTransformation
// parameter name: s -> inputString, s -> encodedString
// variable name: groups -> chunks, groups -> rotatedChunks
// changed list comprehension syntax for splitting and rotating
// used for loop with step for splitting
// added comments for clarity on each step