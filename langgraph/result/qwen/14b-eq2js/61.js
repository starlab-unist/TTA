function validateParentheses(sequence) {
    let balance = 0;
    let index = 0;
    while (index < sequence.length) {
        if (sequence[index] === '(') {
            balance += 1;
        } else if (sequence[index] === ')') {
            balance -= 1;
        }
        if (balance < 0) {
            return false;
        }
        index += 1;
    }
    return balance === 0;
}