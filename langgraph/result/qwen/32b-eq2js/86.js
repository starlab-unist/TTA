function orderWordsCharacters(inputString) {
    const result = [];
    const words = inputString.split(' ');
    for (const word of words) {
        const sortedWord = word.split('').sort().join('');
        result.push(sortedWord);
    }
    return result.join(' ');
}