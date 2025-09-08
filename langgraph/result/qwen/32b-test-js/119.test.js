// Source Code
function matchParens(lst) {
    function check(s) {
        let val = 0;
        for (let i = 0; i < s.length; i++) {
            if (s[i] === '(') {
                val++;
            } else {
                val--;
            }
            if (val < 0) {
                return false;
            }
        }
        return val === 0;
    }

    const S1 = lst[0] + lst[1];
    const S2 = lst[1] + lst[0];
    return check(S1) || check(S2) ? 'Yes' : 'No';
}

// Transformed Code (Semantically Equivalent)
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

// Test Cases
describe('matchParens vs validateParenthesesCombinations equivalence tests', () => {
    const testCases = [
        [["()", "()"], "Yes"],
        [["(", ")"], "Yes"],
        [["(()", "())"], "Yes"],
        [["(", "("], "No"],
        [["))", "(("], "No"],
        [["(())", "()"], "Yes"],
        [["((()))", ""], "Yes"],
        [["", ""], "Yes"],
        [["()(", ")"], "Yes"],
        [["(()", "()())"], "Yes"]
    ];

    test.each(testCases)("given %p and %p, should return %p", (input, expected) => {
        expect(matchParens(input)).toBe(expected);
        expect(validateParenthesesCombinations(input)).toBe(expected);
    });
});