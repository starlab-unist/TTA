function validateParentheses(sequence) {
    let balance = 0;
    let index = 0;
    while (index < sequence.length) {
        if (sequence[index] === '(') {
            balance++;
        } else if (sequence[index] === ')') {
            balance--;
        }
        if (balance < 0) {
            return false;
        }
        index++;
    }
    return balance === 0;
}