// Source Code
function matchParens(lst) {
    function check(s) {
        let val = 0;
        for (let i of s) {
            if (i === '(') {
                val += 1;
            } else {
                val -= 1;
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

    test.each(testCases)('Input: %s, Expected Output: %s', (inputList, expectedOutput) => {
        expect(matchParens(inputList)).toBe(expectedOutput);
        expect(validateParenthesesCombinations(inputList)).toBe(expectedOutput);
    });
});