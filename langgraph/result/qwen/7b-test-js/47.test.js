// Source Code
function median(arr) {
    arr.sort((a, b) => a - b);
    const midIndex = Math.floor(arr.length / 2);

    if (arr.length % 2 === 1) {
        return arr[midIndex];
    } else {
        return (arr[midIndex - 1] + arr[midIndex]) / 2;
    }
}

// Transformed Code (Semantically Equivalent)
function calculateMedian(numbers) {
    const sortedNumbers = [...numbers].sort((a, b) => a - b);
    const midIndex = Math.floor(sortedNumbers.length / 2);

    if (sortedNumbers.length % 2 === 1) {
        return sortedNumbers[midIndex];
    } else {
        return (sortedNumbers[midIndex - 1] + sortedNumbers[midIndex]) / 2.0;
    }
}

// Test Cases
describe('median vs calculateMedian equivalence tests', () => {
    const testCases = [
        ([3, 1, 2], 2),
        ([4, 1, 3, 2], 2.5),
        ([7], 7),
        ([8, 9], 8.5),
        ([10, 2, 5, 1, 8, 9, 3], 5),
        ([5, 5, 5, 5, 5], 5),
        ([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5.5),
        ([100, 200, 300, 400, 500, 600, 700, 800, 900, 1000], 550.0),
        ([1.5, 2.5, 3.5], 2.5),
        ([-1, -2, -3, -4, -5], -3)
    ];

    test.each(testCases)('Input: %p', (inputArray, expectedOutput) => {
        expect(median(inputArray)).toBe(calculateMedian(inputArray));
    });
});