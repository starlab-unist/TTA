function encode(message) {
    const vowels = "aeiouAEIOU";
    const vowelsReplace = {};
    
    for (let i of vowels) {
        vowelsReplace[i] = String.fromCharCode(i.charCodeAt(0) + 2);
    }
    
    message = message.split('').map(char => 
        vowels.includes(char) ? vowelsReplace[char] : char
    ).join('');
    
    return message;
}