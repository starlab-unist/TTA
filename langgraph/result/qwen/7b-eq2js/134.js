function checkIfLastCharIsALetter(txt) {
    const check = txt.split(' ').pop();
    return check.length === 1 && /^[a-z]$/i.test(check);
}