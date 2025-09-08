function parseNestedParens(parenString) {
    function parseParenGroup(s) {
        let depth = 0;
        let maxDepth = 0;
        for (let c of s) {
            if (c === '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if (c === ')') {
                depth--;
            }
        }

        return maxDepth;
    }

    return parenString.split(' ').filter(x => x).map(parseParenGroup);
}