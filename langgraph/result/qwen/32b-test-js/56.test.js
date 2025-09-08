// Source Code
function correctBracketing(brackets) {
    let depth = 0;
    for (let b of brackets) {
        if (b === "<") {
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
function validateBracketSequence(sequence) {
    let level = 0;
    let index = 0;
    while (index < sequence.length) {
        if (sequence[index] === "<") {
            level += 1;
        } else {
            level -= 1;
        }
        if (level < 0) {
            return false;
        }
        index += 1;
    }
    return level === 0;
}

// Test Cases
describe('correctBracketing vs validateBracketSequence equivalence tests', () => {
    const testCases = [
        "<>",
        "<<>>",
        "<<<>>>",
        "><",
        "<<><>>",
        "",
        "<<<<>>>>",
        "<<>><<>>",
        "<<<<><>>",
        "<<<<>>><"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(correctBracketing(inputText)).toBe(validateBracketSequence(inputText));
    });
});