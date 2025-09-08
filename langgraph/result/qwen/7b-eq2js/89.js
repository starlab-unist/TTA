function cipherText(inputString) {
    const alphabet = 'abcdefghijklmnopqrstuvwxyz';
    let result = [];
    for (let i = 0; i < inputString.length; i++) {
        const character = inputString[i];
        if (alphabet.includes(character)) {
            const newIndex = (alphabet.indexOf(character) + 4) % 26;
            result.push(alphabet[newIndex]);
        } else {
            result.push(character);
        }
    }
    return result.join('');
}