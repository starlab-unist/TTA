function encode(message) {
    const vowels = "aeiouAEIOU";
    const vowelsReplace = new Map([...vowels].map((i) => [i, String.fromCharCode(ord(i) + 2)]));
    message = message.split('').map(char => vowelsReplace.get(char) || char).join('');
    return message;
}