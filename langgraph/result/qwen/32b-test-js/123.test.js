// Source Code
function getOddCollatz(n) {
    let oddCollatz = n % 2 === 0 ? [] : [n];
    while (n > 1) {
        if (n % 2 === 0) {
            n = n / 2;
        } else {
            n = n * 3 + 1;
        }
        
        if (n % 2 === 1) {
            oddCollatz.push(n);
        }
    }

    return oddCollatz.sort((a, b) => a - b);
}

// Transformed Code (Semantically Equivalent)
function extractOddNumbersInSequence(startingValue) {
    let sequenceOfOdds;
    if (startingValue % 2 === 0) {
        sequenceOfOdds = [];
    } else {
        sequenceOfOdds = [startingValue];
    }

    let currentValue = startingValue;
    while (currentValue > 1) {
        if (currentValue % 2 === 0) {
            currentValue = Math.floor(currentValue / 2);
        } else {
            currentValue = currentValue * 3 + 1;
        }

        if (currentValue % 2 !== 0) {
            sequenceOfOdds.push(currentValue);
        }
    }

    return sequenceOfOdds.sort((a, b) => a - b);
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
        expect(getOddCollatz(inputNumber)).toEqual(extractOddNumbersInSequence(inputNumber));
    });
});