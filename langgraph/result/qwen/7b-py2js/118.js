function getClosestVowel(word) {
    if (word.length < 3) {
        return "";
    }

    const vowels = new Set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']);
    for (let i = word.length - 2; i > 0; i--) {
        if (vowels.has(word[i])) {
            if (!vowels.has(word[i + 1]) && !vowels.has(word[i - 1])) {
                return word[i];
            }
        }
    }
    return "";
}