function selectWords(s, n) {
    const result = [];
    const words = s.split(' ');

    for (const word of words) {
        let nConsonants = 0;
        for (let i = 0; i < word.length; i++) {
            if (!['a', 'e', 'i', 'o', 'u'].includes(word[i].toLowerCase())) {
                nConsonants++;
            }
        }
        if (nConsonants === n) {
            result.push(word);
        }
    }

    return result;
}