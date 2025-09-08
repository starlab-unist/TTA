function transformMessage(inputText) {
    const vowelSet = "aeiouAEIOU";
    const vowelMapping = {};
    for (const char of vowelSet) {
        vowelMapping[char] = String.fromCharCode(char.charCodeAt(0) + 2);
    }
    let modifiedText = inputText.split('').map(char => char === char.toLowerCase() ? char.toUpperCase() : char.toLowerCase()).join('');
    let result = '';
    for (const char of modifiedText) {
        result += vowelMapping[char] || char;
    }
    return result;
}