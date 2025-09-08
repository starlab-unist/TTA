function checkIfLastCharIsALetter(txt) {
    const words = txt.split(' ');
    const check = words[words.length - 1];
    return check.length === 1 && /^[a-z]$/i.test(check);
}