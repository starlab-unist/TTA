function selectStringsWithStartingChars(strings, prefix) {
    const filteredWords = [];
    for (const word of strings) {
        if (word.startsWith(prefix)) {
            filteredWords.push(word);
        }
    }
    return filteredWords;
}

// method name: filterByPrefix -> selectStringsWithStartingChars
// parameter name: strings -> strings, prefix -> prefix
// changed list comprehension to for loop with push
// variable name: x -> word, result -> filteredWords