function checkIfLastCharIsALetter(txt) {
    const check = txt.split(' ').pop();
    return check.length === 1 && /^[a-zA-Z]$/.test(check);
}