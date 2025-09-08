function selectWords(s, n) {
    const result = [];
    const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
    
    for (const word of s.split(' ')) {
        let nConsonants = 0;
        for (let i = 0; i < word.length; i++) {
            if (!vowels.has(word[i].toLowerCase())) {
                nConsonants++;
            }
        }
        if (nConsonants === n) {
            result.push(word);
        }
    }
    
    return result;
}