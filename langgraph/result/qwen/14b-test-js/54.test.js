// Source Code
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) {
        return false;
    }
    for (let char of set0) {
        if (!set1.has(char)) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function compareCharacterSets(stringOne, stringTwo) {
    const setOfCharsOne = new Set(stringOne);
    const setOfCharsTwo = new Set(stringTwo);
    
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

    test.each(testCases)('Input: "%s", "%s"', (input1, input2) => {
        expect(sameChars(input1, input2)).toBe(compareCharacterSets(input1, input2));
    });
});