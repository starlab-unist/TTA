function transformString(inputString) {
    let modified = false;
    let position = 0;
    let resultChars = inputString.split('');
    for (let char of inputString) {
        if (/[a-zA-Z]/.test(char)) {
            resultChars[position] = char === char.toLowerCase() ? char.toUpperCase() : char.toLowerCase();
            modified = true;
        }
        position += 1;
    }
    let transformedString = resultChars.join('');
    if (!modified) {
        return transformedString.split('').reverse().join('');
    }
    return transformedString;
}