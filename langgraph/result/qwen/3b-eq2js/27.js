function invertCharacterCase(inputText) {
    let result = '';
    for (let char of inputText) {
        if (char === char.toLowerCase()) {
            result += char.toUpperCase();
        } else if (char === char.toUpperCase()) {
            result += char.toLowerCase();
        } else {
            result += char;
        }
    }
    return result;
}

console.log(invertCharacterCase("Alice"));