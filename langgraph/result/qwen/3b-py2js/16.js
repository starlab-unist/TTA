function countDistinctCharacters(string) {
    return new Set(string.toLowerCase()).size;
}