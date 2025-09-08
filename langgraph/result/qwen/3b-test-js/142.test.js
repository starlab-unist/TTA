// Source Code
function sumSquares(lst) {
    let result = [];
    for (let i = 0; i < lst.length; i++) {
        if (i % 3 === 0) {
            result.push(lst[i] ** 2);
        } else if (i % 4 === 0 && i % 3 !== 0) {
            result.push(lst[i] ** 3);
        } else {
            result.push(lst[i]);
        }
    }
    return result.reduce((acc, val) => acc + val, 0);
}

// Transformed Code
function calculateModifiedSum(numbers) {
    let total = 0;
    let index = 0;
    while (index < numbers.length) {
        if (index % 3 === 0) {
            total += Math.pow(numbers[index], 2);
        } else if (index % 4 === 0) {
            total += Math.pow(numbers[index], 3);
        } else {
            total += numbers[index];
        }
        index++;
    }
    return total;
}

// Test Cases
describe('sumSquares vs calculateModifiedSum equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5],          // Simple list with small integers
        [0, 0, 0, 0, 0],          // List of zeros
        [1, 1, 1, 1, 1],          // List of ones
        [-1, -2, -3, -4, -5],     // Simple list with negative integers
        [10, 20, 30, 40, 50],     // List of larger integers
        [9, 8, 7, 6, 5],          // Decreasing list of integers
        [1, -1, 1, -1, 1],        // Alternating positive and negative integers
        [],                       // Empty list
        [2, 3, 4, 5, 6, 7, 8],    // Simple list with small integers
        [5, 0, 10, 0, 15]         // List containing zeros
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(sumSquares(inputArray)).toBe(calculateModifiedSum(inputArray));
    });
});