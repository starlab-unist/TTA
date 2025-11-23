function separateParenGroups(parenString) {
    const result = [];
    let currentString = [];
    let currentDepth = 0;

    for (const c of parenString) {
        if (c === '(') {
            currentDepth += 1;
            currentString.push(c);
        } else if (c === ')') {
            currentDepth -= 1;
            currentString.push(c);

            if (currentDepth === 0) {
                result.push(currentString.join(''));
                currentString = [];
            }
        }
    }

    return result;
}