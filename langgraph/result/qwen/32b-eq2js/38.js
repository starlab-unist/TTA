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