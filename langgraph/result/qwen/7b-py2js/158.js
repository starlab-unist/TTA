function findMax(words) {
    return words.sort((a, b) => {
        const lenA = new Set(a).size;
        const lenB = new Set(b).size;
        if (lenA !== lenB) {
            return lenB - lenA;
        }
        return a.localeCompare(b);
    })[0];
}