function determineIfFinalCharacterIsAlphabetic(inputString) {
    const lastWord = inputString.split(' ').pop();
    return lastWord.length === 1 && 'a' <= lastWord.toLowerCase() <= 'z';
}