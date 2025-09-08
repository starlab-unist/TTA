function validateParentheses(brackets) {
    let depth = 0;
    let index = 0;
    while (index < brackets.length) {
        if (brackets[index] === '(') {
            depth += 1;
        } else if (brackets[index] === ')') {
            depth -= 1;
        }
        if (depth < 0) {
            return false;
        }
        index += 1;
    }
    return depth === 0;
}