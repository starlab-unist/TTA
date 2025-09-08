function orderWordsCharacters(inputString) {
    let result = [];
    for (let word of inputString.split(' ')) {
        let sortedWord = word.split('').sort().join('');
        result.push(sortedWord);
    }
    return result.join(' ');
}