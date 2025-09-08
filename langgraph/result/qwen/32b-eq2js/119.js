function validateParenthesesCombinations(strings) {
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

    const combinedFirstSecond = strings[0] + strings[1];
    const combinedSecondFirst = strings[1] + strings[0];
    
    return isBalanced(combinedFirstSecond) || isBalanced(combinedSecondFirst) ? 'Yes' : 'No';
}