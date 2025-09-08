function extractAndCountWords(inputText) {
    if (inputText.includes(' ')) {
        const wordList = inputText.split(' ');
        return wordList;
    } else if (inputText.includes(',')) {
        const wordList = inputText.replace(',', ' ').split(' ');
        return wordList;
    } else {
        let count = 0;
        for (let char of inputText) {
            if (char >= 'a' && char <= 'z' && char.charCodeAt(0) % 2 === 0) {
                count++;
            }
        }
        return count;
    }
}