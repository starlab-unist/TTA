function determineUniqueCharCount(inputText) {
    const uniqueChars = new Set(inputText.toLowerCase());
    return uniqueChars.size;
}