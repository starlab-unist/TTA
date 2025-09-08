function transformMessage(inputText) {
    const vowelSet = "aeiouAEIOU";
    const vowelMapping = {};
    for (let char of vowelSet) {
        vowelMapping[char] = String.fromCharCode(char.charCodeAt(0) + 2);
    }
    const modifiedText = inputText.split('').map(char => 
        char === char.toLowerCase() ? char.toUpperCase() : char.toLowerCase()
    ).join('');
    let result = '';
    for (let char of modifiedText) {
        result += vowelMapping[char] || char;
    }
    return result;
}