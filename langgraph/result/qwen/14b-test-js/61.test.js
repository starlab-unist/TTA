// Source Code
function correctBracketing(brackets) {
    let depth = 0;
    for (let b of brackets) {
        if (b === "(") {
            depth += 1;
        } else {
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
        expect(correctBracketing(inputText)).toBe(validateParentheses(inputText))
    });
});