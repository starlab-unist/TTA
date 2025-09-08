function shiftEncode(inputString) {
    /**
     * Encodes the input string by shifting each character forward by 5 positions in the alphabet.
     */
    let encodedChars = [];
    for (let character of inputString) {
        let shiftedChar = String.fromCharCode(((character.charCodeAt(0) + 5 - "a".charCodeAt(0)) % 26) + "a".charCodeAt(0));
        encodedChars.push(shiftedChar);
    }
    return encodedChars.join('');
}

function shiftDecode(encodedString) {
    let decodedChars = [];
    let index = 0;
    while (index < encodedString.length) {
        let originalChar = String.fromCharCode(((encodedString.charCodeAt(index) - 5 - "a".charCodeAt(0)) % 26) + "a".charCodeAt(0));
        decodedChars.push(originalChar);
        index++;
    }
    return decodedChars.join('');
}