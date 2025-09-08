function separateParenGroups(parenString) {
    const result = [];
    let currentString = '';
    let currentDepth = 0;

    for (let i = 0; i < parenString.length; i++) {
        const c = parenString[i];
        if (c === '(') {
            currentDepth += 1;
            currentString += c;
        } else if (c === ')') {
            currentDepth -= 1;
            currentString += c;

            if (currentDepth === 0) {
                result.push(currentString);
                currentString = '';
            }
        }
    }

    return result;
}