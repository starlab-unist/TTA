function filterWordsByConsonantCount(inputString, targetConsonantCount) {
    const selectedWords = [];
    const words = inputString.split();

    for (const word of words) {
        let consonantCounter = 0;
        let index = 0;
        while (index < word.length) {
            if (!"aeiou".includes(word[index].toLowerCase())) {
                consonantCounter += 1;
            }
            index += 1;
        }

        if (consonantCounter === targetConsonantCount) {
            selectedWords.push(word);
        }
    }

    return selectedWords;
}