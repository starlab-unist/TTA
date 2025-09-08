// Source Code
function nextSmallest(lst) {
    const uniqueSorted = [...new Set(lst)].sort((a, b) => a - b);
    return uniqueSorted.length < 2 ? null : uniqueSorted[1];
}

// Transformed Code (Semantically Equivalent)
function findSecondMinimum(numbers) {
    const uniqueNumbers = [...new Set(numbers)].sort((a, b) => a - b);

    if (uniqueNumbers.length < 2) {
        return null;
    }

    return uniqueNumbers[1];
}

// Test Cases
describe('nextSmallest vs findSecondMinimum equivalence tests', () => {
    const testCases = [
        [3, 1, 4, 1, 5, 9],
        [10, 20, 20, 10, 30],
        [1, 2, 3, 4, 5],
        [5, 5, 5, 5, 5],
        [7],
        [],
        [9, 8, 7, 6, 5, 4, 3, 2, 1],
        [0, -1, -2, -3, -4],
        [-10, -20, -10, -30, -20],
        [100, 200, 300, 100, 200, 300]
    ];

    const expectedResults = [
        3,
        20,
        2,
        null,
        null,
        null,
        2,
        -3,
        -20,
        200
    ];

    testCases.forEach((testCase, index) => {
        test(`Input: ${JSON.stringify(testCase)}`, () => {
            expect(nextSmallest(testCase)).toBe(expectedResults[index]);
            expect(findSecondMinimum(testCase)).toBe(expectedResults[index]);
        });
    });
});