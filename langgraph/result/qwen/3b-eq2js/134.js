function determineIfFinalCharacterIsAlphabetic(inputString) {
    const lastWord = inputString.split(' ').pop();
    return lastWord.length === 1 && 'a'.charCodeAt(0) <= lastWord.toLowerCase().charCodeAt(0) && lastWord.toLowerCase().charCodeAt(0) <= 'z'.charCodeAt(0);
}