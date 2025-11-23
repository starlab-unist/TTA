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

describe('belowZero vs checkNegativeBalance equivalence tests', () => {
    const testCases = [
        [1, 2, 3],
        [1, -2, 3],
        [1, 2, -3],
        [-1, 2, 3],
        [1, -1, 2],
        [10, -5, -10],
        [],
        [0, 0, 0],
        [1, 2, 3, -7],
        [5, -3, -4]
    ];

    test.each(testCases)('Input: %p', (input) => {
        expect(belowZero(input)).toBe(checkNegativeBalance(input));
    });
});