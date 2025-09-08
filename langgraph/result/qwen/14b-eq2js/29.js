function selectStringsStartingWithChars(wordList, startSequence) {
    const filteredWords = [];
    for (const word of wordList) {
        if (word.startsWith(startSequence)) {
            filteredWords.push(word);
        }
    }
    return filteredWords;
}

// method name: filter_by_prefix -> selectStringsStartingWithChars
// parameter name: strings -> wordList, prefix -> startSequence
// changed list comprehension to for loop with push
// variable name: x -> word, result -> filteredWords