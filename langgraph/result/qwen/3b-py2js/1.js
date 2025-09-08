function separateParenGroups(parenString) {
    let result = [];
    let currentString = [];
    let currentDepth = 0;

    for (let c of parenString) {
        if (c === '(') {
            currentDepth++;
            currentString.push(c);
        } else if (c === ')') {
            currentDepth--;
            currentString.push(c);

            if (currentDepth === 0) {
                result.push(currentString.join(''));
                currentString = [];
            }
        }
    }

    return result;
}