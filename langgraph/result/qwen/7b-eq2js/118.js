function findNearestIsolatedVowel(word) {
    if (word.length < 3) {
        return "";
    }

    const vowels = new Set("aeiouAEIOU");
    let index = word.length - 3;

    while (index > 0) {
        if (vowels.has(word[index])) {
            if (!vowels.has(word[index + 1]) && !vowels.has(word[index - 1])) {
                return word[index];
            }
        }
        index -= 1;
    }

    return "";
}