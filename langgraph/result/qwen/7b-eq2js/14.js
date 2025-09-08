function generateStringPrefixes(inputStr) {
    let prefixes = [];
    let index = 0;

    while (index < inputStr.length) {
        prefixes.push(inputStr.substring(0, index + 1));
        index++;
    }

    return prefixes;
}

// method name: all_prefixes -> generateStringPrefixes
// parameter name: string -> inputStr
// variable name: result -> prefixes, i -> index
// changed for loop to while loop