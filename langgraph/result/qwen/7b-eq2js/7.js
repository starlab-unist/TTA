function extractMatchingStrings(strings, substring) {
    const result = [];
    let index = 0;
    while (index < strings.length) {
        if (strings[index].includes(substring)) {
            result.push(strings[index]);
        }
        index++;
    }
    return result;
}