// Source Code
function chooseNum(x, y) {
    if (x > y) {
        return -1;
    }
    if (y % 2 === 0) {
        return y;
    }
    if (x === y) {
        return -1;
    }
    return y - 1;
}

// Transformed Code (Semantically Equivalent)
function selectNumber(a, b) {
    if (a > b) {
        return -1;
    } else if (b % 2 === 0) {
        return b;
    } else if (a === b) {
        return -1;
    } else {
        return b - 1;
    }
}

// Test Cases
describe('chooseNum vs selectNumber equivalence tests', () => {
    const testCases = [
        [3, 5],     // y > x and y is odd
        [4, 4],     // x == y
        [2, 6],     // y > x and y is even
        [7, 8],     // y > x and y is even
        [10, 10],   // x == y
        [5, 3],     // x > y
        [0, 2],     // y > x and y is even
        [1, 1],     // x == y
        [9, 11],    // y > x and y is odd
        [6, 7]      // y > x and y is odd
    ];

    test.each(testCases)('Input: (%i, %i)', (x, y) => {
        expect(chooseNum(x, y)).toBe(selectNumber(x, y));
    });
});