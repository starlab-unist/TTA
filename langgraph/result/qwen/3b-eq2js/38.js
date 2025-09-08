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

// method name: encodeCyclic -> transformCyclicString
// method name: decodeCyclic -> reverseCyclicTransformation
// parameter name: s -> inputString, s -> encodedString
// variable name: groups -> chunks, groups -> rotatedChunks
// changed list comprehension syntax for splitting and rotating
// used range with step in list comprehension for splitting
// added comments for clarity on each step