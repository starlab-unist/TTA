// Source Code
function sameChars(s0, s1) {
    return new Set(s0).size === new Set(s1).size;
}

// Transformed Code (Semantically Equivalent)
function compareCharacterSets(s0, s1) {
    const setOfCharsOne = new Set(s0);
    const setOfCharsTwo = new Set(s1);

    return setOfCharsOne.size === setOfCharsTwo.size && [...setOfCharsOne].every(char => setOfCharsTwo.has(char));
}

// Test Cases
describe('sameChars vs compareCharacterSets equivalence tests', () => {
    const testCases = [
        ["hello", "olleh"],
        ["world", "dlrow"],
        ["python", "nothyp"],
        ["openai", "ipaneo"],
        ["", ""],
        ["a", "a"],
        ["ab", "ba"],
        ["abc", "cba"],
        ["abcd", "dcba"],
        ["xyz", "zyx"]
    ];

    test.each(testCases)('Input: "%s" and "%s"', (input0, input1) => {
        expect(sameChars(input0, input1)).toBe(compareCharacterSets(input0, input1));
    });
});