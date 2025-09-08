// Source Code
function getOddCollatz(n) {
    let oddCollatz = [];
    if (n % 2 !== 0) {
        oddCollatz.push(n);
    }
    while (n > 1) {
        if (n % 2 === 0) {
            n /= 2;
        } else {
            n = n * 3 + 1;
        }
        if (n % 2 === 1) {
            oddCollatz.push(Math.floor(n));
        }
    }
    return oddCollatz.sort((a, b) => a - b);
}

// Transformed Code (Semantically Equivalent)
function extractOddNumbersInSequence(n) {
    let oddCollatz = [];
    if (n % 2 === 0) {
        oddCollatz = [];
    } else {
        oddCollatz.push(n);
    }

    let currentValue = n;
    while (currentValue > 1) {
        if (currentValue % 2 === 0) {
            currentValue /= 2;
        } else {
            currentValue = currentValue * 3 + 1;
        }

        if (currentValue % 2 !== 0) {
            oddCollatz.push(currentValue);
        }
    }

    return oddCollatz.sort((a, b) => a - b);
}

// Test Cases
describe('getOddCollatz vs extractOddNumbersInSequence equivalence tests', () => {
    const testCases = [
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(getOddCollatz(inputNumber)).toEqual(extractOddNumbersInSequence(inputNumber))
    });
});