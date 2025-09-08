function findMax(words) {
    return words.sort((a, b) => {
        const uniqueA = new Set(a).size;
        const uniqueB = new Set(b).size;
        if (uniqueA === uniqueB) {
            return a.localeCompare(b);
        }
        return uniqueB - uniqueA;
    })[0];
}