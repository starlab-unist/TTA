function findMax(words) {
    return words.sort((a, b) => {
        const uniqueCharsA = new Set(a).size;
        const uniqueCharsB = new Set(b).size;
        if (uniqueCharsA !== uniqueCharsB) {
            return uniqueCharsB - uniqueCharsA;
        }
        return a.localeCompare(b);
    })[0];
}