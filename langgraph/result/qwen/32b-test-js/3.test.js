// Source Code
function belowZero(operations) {
    let balance = 0;

    for (let op of operations) {
        balance += op;
        if (balance < 0) {
            return true;
        }
    }

    return false;
}

// Transformed Code (Semantically Equivalent)
function checkNegativeBalance(transactions) {
    let currentBalance = 0;

    let index = 0;
    while (index < transactions.length) {
        currentBalance += transactions[index];
        if (currentBalance < 0) {
            return true;
        }
        index += 1;
    }

    return false;
}

// Test Cases
describe('belowZero vs checkNegativeBalance equivalence tests', () => {
    const testCases = [
        { input: [], expected: false },
        { input: [1, 2, 3], expected: false },
        { input: [-1, -2, -3], expected: true },
        { input: [10, -5, -6], expected: true },
        { input: [10, -5, 5], expected: false },
        { input: [0, 0, 0], expected: false },
        { input: [1, -1, 1, -1, 1, -2], expected: true },
        { input: [-1, 1, -1, 1, -1, 1], expected: true },
        { input: [1, 2, 3, -7], expected: true },
        { input: [5, 5, 5, 5, -20], expected: true }
    ];

    test.each(testCases)('Input: "%o", Expected Output: "$o"', ({ input, expected }) => {
        expect(belowZero(input)).toBe(checkNegativeBalance(input));
    });
});