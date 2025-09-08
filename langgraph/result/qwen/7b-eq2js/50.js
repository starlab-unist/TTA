function shiftEncode(inputString) {
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
        index += 1;
    }
    return decodedChars.join('');
}

// method name: encodeShift -> shiftEncode
// method name: decodeShift -> shiftDecode
// parameter name: s -> inputString, s -> encodedString
// replaced list comprehension with for loop in shiftEncode
// replaced list comprehension with while loop in shiftDecode
// used push method to add characters to the array instead of using join directly on the comprehension