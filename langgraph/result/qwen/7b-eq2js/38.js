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