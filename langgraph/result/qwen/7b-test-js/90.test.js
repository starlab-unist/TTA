// Source Code
function nextSmallest(arr) {
    arr = [...new Set(arr)].sort((a, b) => a - b);
    return arr.length < 2 ? null : arr[1];
}

// Transformed Code (Semantically Equivalent)
function findSecondMinimum(numbers) {
    let uniqueNumbers = Array.from(new Set(numbers)).sort((a, b) => a - b);

    if (uniqueNumbers.length < 2) {
        return null;
    }

    return uniqueNumbers[1];
}

// Test Cases
describe('nextSmallest vs findSecondMinimum equivalence tests', () => {
    const testCases = [
        ([3, 1, 4, 1, 5, 9], 3),
        ([10, 20, 20, 10, 30], 20),
        ([1, 2, 3, 4, 5], 2),
        ([5, 5, 5, 5, 5], null),
        ([7], null),
        ([], null),
        ([9, 8, 7, 6, 5, 4, 3, 2, 1], 2),
        ([0, -1, -2, -3, -4], -3),
        ([-10, -20, -10, -30, -20], -20),
        ([100, 200, 300, 100, 200, 300], 200)
    ];

    test.each(testCases)('Input: %p', (inputArray, expectedOutput) => {
        expect(nextSmallest(inputArray)).toBe(findSecondMinimum(inputArray));
    });
});