function determineLongestUniqueCharString(wordList) {
    function customSortKey(word) {
        const uniqueChars = new Set(word).size;
        return [-uniqueChars, word];
    }
    
    const sortedWords = wordList.sort((a, b) => {
        const keyA = customSortKey(a);
        const keyB = customSortKey(b);
        
        if (keyA[0] !== keyB[0]) {
            return keyA[0] - keyB[0];
        }
        return keyA[1].localeCompare(keyB[1]);
    });
    
    return sortedWords[0];
}