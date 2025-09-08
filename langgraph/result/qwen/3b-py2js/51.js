function removeVowels(text) {
    return text.split('').filter(s => !'aeiouAEIOU'.includes(s)).join('');
}