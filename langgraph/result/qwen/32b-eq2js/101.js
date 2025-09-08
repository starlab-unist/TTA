function processText(inputString) {
    if (!inputString) {
        return [];
    }

    const processedChars = [];

    let index = 0;
    while (index < inputString.length) {
        const char = inputString[index];
        if (char === ',') {
            processedChars.push(' ');
        } else {
            processedChars.push(char);
        }
        index += 1;
    }

    const processedString = processedChars.join('');
    return processedString.split(/\s+/);
}