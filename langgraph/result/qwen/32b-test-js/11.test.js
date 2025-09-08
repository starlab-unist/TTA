// Source Code
function stringXor(a, b) {
    function xor(i, j) {
        return i === j ? '0' : '1';
    }

    let result = '';
    for (let i = 0; i < Math.min(a.length, b.length); i++) {
        result += xor(a[i], b[i]);
    }
    return result;
}

// Transformed Code (Semantically Equivalent)
function binaryStringDifference(str1, str2) {
    function bitDiff(c1, c2) {
        return c1 === c2 ? '0' : '1';
    }

    let result = [];
    let index = 0;
    while (index < str1.length && index < str2.length) { // Ensure both strings are within bounds
        result.push(bitDiff(str1[index], str2[index]));
        index += 1;
    }

    return result.join('');
}

// Test Cases
describe('stringXor vs binaryStringDifference equivalence tests', () => {
    const testCases = [
        ["1101", "1001"],
        ["1111", "0000"],
        ["0000", "0000"],
        ["101010", "010101"],
        ["111000", "111000"],
        ["110011", "001100"],
        ["1", "1"],
        ["0", "0"],
        ["10", "01"],
        ["11111111", "00000000"]
    ];

    test.each(testCases)('Input: "%s" and "%s"', (a, b) => {
        expect(stringXor(a, b)).toBe(binaryStringDifference(a, b));
    });
});