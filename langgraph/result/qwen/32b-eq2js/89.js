function cipherText(inputString) {
    const alphabet = 'abcdefghijklmnopqrstuvwxyz';
    let result = [];
    for (let character of inputString) {
        if (alphabet.includes(character)) {
            let newIndex = (alphabet.indexOf(character) + 4) % 26;
            result.push(alphabet[newIndex]);
        } else {
            result.push(character);
        }
    }
    return result.join('');
}