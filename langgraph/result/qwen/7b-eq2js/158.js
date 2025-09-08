function determineLongestUniqueCharString(words) {
    function customSortKey(word) {
        const uniqueChars = new Set(word);
        return [-uniqueChars.size, word];
    }

    const sortedWords = words.sort(customSortKey);
    return sortedWords[0];
}