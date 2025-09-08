function stripVowels(inputString) {
    const vowels = new Set("aeiouAEIOU");
    let result = [];
    let index = 0;

    while (index < inputString.length) {
        const char = inputString[index];
        if (!vowels.has(char)) {
            result.push(char);
        }
        index++;
    }

    return result.join('');
}