// Source Code
function anyInt(x, y, z) {
    if (Number.isInteger(x) && Number.isInteger(y) && Number.isInteger(z)) {
        if ((x + y === z) || (x + z === y) || (y + z === x)) {
            return true;
        }
        return false;
    }
    return false;
}

// Transformed Code (Semantically Equivalent)
function checkSumOfTwoEqualsThird(a, b, c) {
    if (Number.isInteger(a) && Number.isInteger(b) && Number.isInteger(c)) {
        if (a + b === c || a + c === b || b + c === a) {
            return true;
        }
        return false;
    }
    return false;
}

// Test Cases
describe('anyInt vs checkSumOfTwoEqualsThird equivalence tests', () => {
    const testCases = [
        [1, 2, 3],   // True: 1 + 2 == 3
        [5, 3, 2],   // True: 3 + 2 == 5
        [4, 6, 10],  // True: 4 + 6 == 10
        [7, 3, 4],   // True: 3 + 4 == 7
        [1, 1, 2],   // True: 1 + 1 == 2
        [10, 5, 5],  // False: No two numbers sum to the third
        [0, 0, 0],   // True: 0 + 0 == 0
        [-1, -2, -3],# True: -1 + -2 == -3
        [1.5, 2, 3.5], // False: Not all inputs are integers
        ["a", 2, 3]   // False: Not all inputs are integers
    ];

    test.each(testCases)('Input: (%s, %s, %s)', (x, y, z) => {
        expect(anyInt(x, y, z)).toBe(checkSumOfTwoEqualsThird(x, y, z));
    });
});