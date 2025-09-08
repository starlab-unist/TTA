function filterWordsByConsonantCount(inputString, targetConsonantCount) {
    const selectedWords = [];
    const words = inputString.split(' ');

    for (let i = 0; i < words.length; i++) {
        let consonantCounter = 0;
        let index = 0;
        while (index < words[i].length) {
            if (!'aeiou'.includes(words[i][index].toLowerCase())) {
                consonantCounter += 1;
            }
            index += 1;
        }

        if (consonantCounter === targetConsonantCount) {
            selectedWords.push(words[i]);
        }
    }

    return selectedWords;
}