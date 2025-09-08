function countDistinctCharacters(string) {
    const lowerCaseString = string.toLowerCase();
    const distinctCharacters = new Set(lowerCaseString);
    return distinctCharacters.size;
}