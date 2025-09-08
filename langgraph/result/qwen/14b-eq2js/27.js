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

// method name: flip_case -> invertCharacterCase
// parameter name: string -> inputText
// replaced swapcase() with manual character case inversion using a loop and conditionals