function orderWordsCharacters(s) {
    let result = [];
    for (let word of s.split(' ')) {
        let sortedWord = word.split('').sort().join('');
        result.push(sortedWord);
    }
    return result.join(' ');
}