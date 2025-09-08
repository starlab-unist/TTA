function determineLongestUniqueCharString(wordList) {
    function customSortKey(word) {
        return [-new Set(word).size, word];
    }

    const sortedWords = wordList.sort((a, b) => {
        const [lenA, strA] = customSortKey(a);
        const [lenB, strB] = customSortKey(b);
        if (lenA !== lenB) {
            return lenA - lenB;
        }
        return strA.localeCompare(strB);
    });

    return sortedWords[0];
}