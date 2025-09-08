// Source Code
function minSubArraySum(nums) {
    let maxSum = 0;
    let s = 0;
    for (let num of nums) {
        s += -num;
        if (s < 0) {
            s = 0;
        }
        maxSum = Math.max(s, maxSum);
    }
    if (maxSum === 0) {
        maxSum = Math.max(...nums.map(i => -i));
    }
    const minSum = -maxSum;
    return minSum;
}

// Transformed Code (Semantically Equivalent)
function calculateMinimumSubarraySum(numbers) {
    let currentSum = 0;
    let highestNegativeSum = 0;
    for (let value of numbers) {
        currentSum += -value;
        if (currentSum < 0) {
            currentSum = 0;
        }
        highestNegativeSum = Math.max(currentSum, highestNegativeSum);
    }

    if (highestNegativeSum === 0) {
        highestNegativeSum = Math.max(...numbers.map(val => -val));
    }

    const minimumSum = -highestNegativeSum;
    return minimumSum;
}

// Test Cases
describe('minSubArraySum vs calculateMinimumSubarraySum equivalence tests', () => {
    const testCases = [
        { input: [1, 2, 3], expected: -6 },
        { input: [-1, -2, -3, -4], expected: -10 },
        { input: [5, -1, 5], expected: -1 },
        { input: [0, 0, 0], expected: 0 },
        { input: [1], expected: -1 },
        { input: [-1], expected: -1 },
        { input: [1, -1, 1, -1], expected: -2 },
        { input: [3, -4, 2, -3, -1, 7, -5], expected: -6 },
        { input: [10, -3, 4, -2, -1, 10], expected: -6 },
        { input: [], expected: 0 },  // Edge case: empty list
    ];

    test.each(testCases)('Input: %o', ({ input, expected }) => {
        expect(minSubArraySum(input)).toBe(calculateMinimumSubarraySum(input));
    });
});