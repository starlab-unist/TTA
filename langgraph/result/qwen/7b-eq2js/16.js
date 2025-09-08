function determineUniqueCharCount(inputText) {
    let uniqueChars = new Set(inputText.toLowerCase());
    return uniqueChars.size;
}