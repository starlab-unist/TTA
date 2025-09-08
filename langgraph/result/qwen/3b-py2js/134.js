function checkIfLastCharIsALetter(txt) {
    const words = txt.split(' ');
    const lastWord = words[words.length - 1];
    return lastWord.length === 1 && (lastWord.toLowerCase().charCodeAt(0) >= 97 && lastWord.toLowerCase().charCodeAt(0) <= 122);
}