function extractAndCountWords(txt) {
    let words;
    if (' ' in txt) {
        words = txt.split(' ');
    } else if (',' in txt) {
        words = txt.replace(',', ' ').split(' ');
    } else {
        const count = Array.from(txt).reduce((acc, char) => {
            if (char >= 'a' && char <= 'z' && char.charCodeAt(0) % 2 === 0) {
                acc++;
            }
            return acc;
        }, 0);
        return count;
    }

    return words;
}