function selectStringsWithStartingChars(wordList, startSequence) {
    const filteredWords = [];
    for (let word of wordList) {
        if (word.startsWith(startSequence)) {
            filteredWords.push(word);
        }
    }
    return filteredWords;
}