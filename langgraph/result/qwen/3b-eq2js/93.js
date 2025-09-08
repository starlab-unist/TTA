function transformMessage(inputText) {
    const vowelSet = "aeiouAEIOU";
    const vowelMapping = new Map([...vowelSet].map(char => [char, String.fromCharCode(char.charCodeAt(0) + 2)]));
    let modifiedText = inputText.toUpperCase();
    let result = '';
    for (let char of modifiedText) {
        result += vowelMapping.get(char) || char;
    }
    return result;
}

// method name: encode -> transformMessage
// parameter name: message -> inputText
// variable name: vowels -> vowelSet, vowelsReplace -> vowelMapping
// replaced list comprehension with map for vowel mapping
// used Array.prototype.join with a function for constructing the result string
// replaced ternary operator with map.get method for cleaner lookup