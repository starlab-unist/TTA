// Source Code
function matchParens(lst) {
    function check(s) {
        let val = 0;
        for (let i = 0; i < s.length; i++) {
            if (s[i] === '(') {
                val += 1;
            } else {
                val -= 1;
            }
            if (val < 0) {
                return false;
            }
        }
        return val === 0 ? true : false;
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
                balance++;
            } else if (char === ')') {
                balance--;
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

    testCases.forEach(([input, expectedOutput], index) => {
        it(`Test Case ${index}`, () => {
            expect(matchParens(input)).toBe(expectedOutput);
            expect(validateParenthesesCombinations(input)).toBe(expectedOutput);
        });
    });
});