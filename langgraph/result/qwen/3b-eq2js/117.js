function filterWordsByConsonantCount(inputString, targetConsonantCount) {
    let selectedWords = [];
    let words = inputString.split(' ');

    for (let i = 0; i < words.length; i++) {
        let word = words[i];
        let consonantCounter = 0;

        for (let j = 0; j < word.length; j++) {
            if ('aeiou'.indexOf(word[j].toLowerCase()) === -1) {
                consonantCounter++;
            }
        }

        if (consonantCounter === targetConsonantCount) {
            selectedWords.push(word);
        }
    }

    return selectedWords;
}

// method name: selectWords -> filterWordsByConsonantCount
// parameter name: s -> inputString, n -> targetConsonantCount
// variable name: result -> selectedWords, word -> word, n_consonants -> consonantCounter
// changed for loop to while loop for counting consonants
// used string literal "aeiou" instead of list for vowel check