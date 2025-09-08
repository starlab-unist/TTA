function generateStringPrefixes(inputStr) {
    const prefixes = [];
    let index = 0;

    while (index < inputStr.length) {
        prefixes.push(inputStr.substring(0, index + 1));
        index += 1;
    }

    return prefixes;
}