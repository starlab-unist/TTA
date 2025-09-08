// Source Code
function stringXOR(a, b) {
    function xor(i, j) {
        if (i === j) {
            return '0';
        } else {
            return '1';
        }
    }

    let result = '';
    for (let i = 0; i < a.length && i < b.length; i++) {
        result += xor(a[i], b[i]);
    }
    return result;
}

// Transformed Code (Semantically Equivalent)
function binaryStringDifference(a, b) {
    function bitDiff(c1, c2) {
        return c1 === c2 ? '0' : '1';
    }

    let result = [];
    let index = 0;
    while (index < a.length) {
        result.push(bitDiff(a[index], b[index]));
        index += 1;
    }

    return result.join('');
}

// Test Cases
describe('stringXOR vs binaryStringDifference equivalence tests', () => {
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

    test.each(testCases)('Input: "%s" and "%s"', (inputA, inputB) => {
        expect(stringXOR(inputA, inputB)).toBe(binaryStringDifference(inputA, inputB));
    });
});