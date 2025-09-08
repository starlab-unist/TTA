function extractAndCountWords(inputText) {
    if (inputText.includes(' ')) {
        const wordList = inputText.split(' ');
    } else if (inputText.includes(',')) {
        const wordList = inputText.replace(',', ' ').split(' ');
    } else {
        const count = Array.from(inputText).reduce((acc, char) => {
            if (char.toLowerCase().charCodeAt(0) % 2 === 0 && char.toLowerCase() !== char.toUpperCase()) {
                acc++;
            }
            return acc;
        }, 0);
        return count;
    }

    return wordList;
}