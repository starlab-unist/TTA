function generateStringPrefixes(inputStr) {
    let prefixes = [];
    let index = 0;

    while (index < inputStr.length) {
        prefixes.push(inputStr.substring(0, index + 1));
        index++;
    }

    return prefixes;
}