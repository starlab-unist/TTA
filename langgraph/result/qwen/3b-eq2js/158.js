function determineLongestUniqueCharString(wordList) {
    function customSortKey(word) {
        return [-word.length, word];
    }

    const sortedWords = wordList.sort((a, b) => customSortKey(a).localeCompare(customSortKey(b)));
    return sortedWords[0];
}