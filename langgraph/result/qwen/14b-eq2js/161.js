function transformString(inputString) {
    let modified = false;
    let position = 0;
    let resultChars = inputString.split('');

    for (let char of inputString) {
        if (/[a-zA-Z]/.test(char)) {
            resultChars[position] = char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase();
            modified = true;
        }
        position += 1;
    }

    const transformedString = resultChars.join('');
    if (!modified) {
        return transformedString.split('').reverse().join('');
    }
    return transformedString;
}