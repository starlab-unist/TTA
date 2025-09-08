function calculateUppercaseAsciiSum(inputString) {
    if (inputString === "") {
        return 0;
    }

    let total = 0;
    for (let i = 0; i < inputString.length; i++) {
        const character = inputString[i];
        if (character >= 'A' && character <= 'Z') {
            total += character.charCodeAt(0);
        }
    }

    return total;
}