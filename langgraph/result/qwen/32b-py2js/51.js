function removeVowels(text) {
    return text.split('').filter(s => !["a", "e", "i", "o", "u"].includes(s.toLowerCase())).join('');
}