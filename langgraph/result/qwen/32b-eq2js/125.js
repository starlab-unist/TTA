function extractAndCountWords(inputText) {
    let wordList;
    if (inputText.includes(' ')) {
        wordList = inputText.split(/\s+/);
    } else if (inputText.includes(',')) {
        wordList = inputText.replace(/,/g, ' ').split(/\s+/);
    } else {
        const count = [...inputText].reduce((acc, char) => {
            return acc + (char >= 'a' && char <= 'z' && char.charCodeAt(0) % 2 === 0 ? 1 : 0);
        }, 0);
        return count;
    }

    return wordList;
}