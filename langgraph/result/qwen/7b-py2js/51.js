function removeVowels(text) {
    return text.split('').filter(s => !'aeiou'.includes(s.toLowerCase())).join('');
}