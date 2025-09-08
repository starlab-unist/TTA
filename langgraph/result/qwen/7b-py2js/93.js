function encode(message) {
    const vowels = 'aeiouAEIOU';
    const vowelsReplace = {};
    for (const vowel of vowels) {
        vowelsReplace[vowel] = String.fromCharCode(vowel.charCodeAt(0) + 2);
    }
    message = message.split('').map(char => char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase()).join('');
    return Array.from(message).map(char => vowels.includes(char) ? vowelsReplace[char] : char).join('');
}