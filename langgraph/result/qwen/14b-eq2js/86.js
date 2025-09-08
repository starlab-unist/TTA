function orderWordsCharacters(inputString) {
    const result = [];
    for (const word of inputString.split(' ')) {
        const sortedWord = word.split('').sort().join('');
        result.push(sortedWord);
    }
    return result.join(' ');
}