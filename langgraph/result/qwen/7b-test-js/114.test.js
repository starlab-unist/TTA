// Source Code
function minSubArraySum(nums) {
    let max_sum = 0;
    let s = 0;
    for (let num of nums) {
        s += -num;
        if (s < 0) {
            s = 0;
        }
        max_sum = Math.max(s, max_sum);
    }
    if (max_sum === 0) {
        max_sum = Math.max(...nums.map(i => -i));
    }
    const min_sum = -max_sum;
    return min_sum;
}

// Transformed Code (Semantically Equivalent)
function calculateMinimumSubarraySum(nums) {
    let currentSum = 0;
    let highestNegativeSum = 0;
    for (let value of nums) {
        currentSum += -value;
        if (currentSum < 0) {
            currentSum = 0;
        }
        highestNegativeSum = Math.max(currentSum, highestNegativeSum);
    }

    if (highestNegativeSum === 0) {
        highestNegativeSum = Math.max(...nums.map(val => -val));
    }

    const minimumSum = -highestNegativeSum;
    return minimumSum;
}

// Test Cases
describe('minSubArraySum vs calculateMinimumSubarraySum equivalence tests', () => {
    const testCases = [
        [[1, 2, 3], -6],
        [[-1, -2, -3, -4], -10],
        [[5, -1, 5], -1],
        [[0, 0, 0], 0],
        [[1], -1],
        [[-1], -1],
        [[1, -1, 1, -1], -2],
        [[3, -4, 2, -3, -1, 7, -5], -6],
        [[10, -3, 4, -2, -1, 10], -6],
        [[], 0],  // Edge case: empty list
    ];

    test.each(testCases)('Input: %j', (inputArray, expectedOutput) => {
        expect(minSubArraySum(inputArray)).toBe(calculateMinimumSubarraySum(inputArray));
    });
});