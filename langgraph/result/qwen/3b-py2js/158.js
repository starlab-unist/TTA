function findMax(words) {
    return words.sort((a, b) => {
        const aUniqueChars = new Set(a).size;
        const bUniqueChars = new Set(b).size;
        if (aUniqueChars === bUniqueChars) {
            return a.localeCompare(b);
        }
        return bUniqueChars - aUniqueChars;
    })[0];
}