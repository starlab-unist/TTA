function validateParenthesesCombinations(lst) {
    function isBalanced(expression) {
        let balance = 0;
        for (let char of expression) {
            if (char === '(') {
                balance += 1;
            } else if (char === ')') {
                balance -= 1;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance === 0;
    }

    const S1 = lst[0] + lst[1];
    const S2 = lst[1] + lst[0];

    if (isBalanced(S1) || isBalanced(S2)) {
        return 'Yes';
    } else {
        return 'No';
    }
}