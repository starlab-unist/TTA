function allPrefixes(string) {
    const result = [];

    for (let i = 0; i < string.length; i++) {
        result.push(string.substring(0, i + 1));
    }
    return result;
}