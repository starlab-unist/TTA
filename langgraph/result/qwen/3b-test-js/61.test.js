// Source Code
function correctBracketing(brackets) {
    let depth = 0;
    for (let b of brackets) {
        if (b === '(') {
            depth += 1;
        } else if (b === ')') {
            depth -= 1;
        }
        if (depth < 0) {
            return false;
        }
    }
    return depth === 0;
}

// Transformed Code (Semantically Equivalent)
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

// Test Cases
describe('correctBracketing vs validateParentheses equivalence tests', () => {
    const testCases = [
        "()",
        "(())",
        "((()))",
        "(()())",
        ")(",
        "(()",
        "())",
        "",
        "((((()))))",
        "(()))(()"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(correctBracketing(inputText)).toBe(validateParentheses(inputText));
    });
});