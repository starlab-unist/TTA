// Source Code
function median(arr) {
    arr = arr.slice().sort((a, b) => a - b);
    const mid = Math.floor(arr.length / 2);
    if (arr.length % 2 === 1) {
        return arr[mid];
    } else {
        return (arr[mid - 1] + arr[mid]) / 2.0;
    }
}

// Transformed Code (Semantically Equivalent)
function calculateMedian(numbers) {
    const sortedNumbers = numbers.slice().sort((a, b) => a - b);
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
        { input: [3, 1, 2], expected: 2 },
        { input: [4, 1, 3, 2], expected: 2.5 },
        { input: [7], expected: 7 },
        { input: [8, 9], expected: 8.5 },
        { input: [10, 2, 5, 1, 8, 9, 3], expected: 5 },
        { input: [5, 5, 5, 5, 5], expected: 5 },
        { input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], expected: 5.5 },
        { input: [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000], expected: 550.0 },
        { input: [1.5, 2.5, 3.5], expected: 2.5 },
        { input: [-1, -2, -3, -4, -5], expected: -3 }
    ];

    test.each(testCases)('Input: $input', ({ input, expected }) => {
        expect(median(input)).toBe(expected);
        expect(calculateMedian(input)).toBe(expected);
        expect(median(input)).toBe(calculateMedian(input));
    });
});