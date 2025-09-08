function checkIfLastCharIsALetter(txt) {
    const check = txt.split(' ').pop();
    return check.length === 1 && (check.toLowerCase().charCodeAt(0) >= 97 && check.toLowerCase().charCodeAt(0) <= 122);
}