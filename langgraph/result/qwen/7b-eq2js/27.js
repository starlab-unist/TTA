function invertCharacterCase(inputText) {
    let result = '';
    for (let i = 0; i < inputText.length; i++) {
        let char = inputText[i];
        if (char >= 'a' && char <= 'z') {
            result += char.toUpperCase();
        } else if (char >= 'A' && char <= 'Z') {
            result += char.toLowerCase();
        } else {
            result += char;
        }
    }
    return result;
}

// renamed function and parameter to match JavaScript conventions