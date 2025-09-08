function transformString(inputString) {
    let modified = false;
    let position = 0;
    let resultChars = Array.from(inputString);
    for (let char of inputString) {
        if (char.match(/[a-zA-Z]/)) {
            resultChars[position] = char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase();
            modified = true;
        }
        position++;
    }
    let transformedString = resultChars.join('');
    if (!modified) {
        return transformedString.split('').reverse().join('');
    }
    return transformedString;
}