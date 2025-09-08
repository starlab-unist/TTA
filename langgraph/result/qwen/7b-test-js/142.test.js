// Source Code
function sumSquares(arr) {
    let result = [];
    for (let i = 0; i < arr.length; i++) {
        if (i % 3 === 0) {
            result.push(arr[i] ** 2);
        } else if (i % 4 === 0 && i % 3 !== 0) {
            result.push(arr[i] ** 3);
        } else {
            result.push(arr[i]);
        }
    }
    return result.reduce((acc, val) => acc + val, 0);
}

// Transformed Code
function calculateModifiedSum(lst) {
    let total = 0;
    let index = 0;
    while (index < lst.length) {
        if (index % 3 === 0) {
            total += Math.pow(lst[index], 2);
        } else if (index % 4 === 0) {
            total += Math.pow(lst[index], 3);
        } else {
            total += lst[index];
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

    test.each(testCases)('testing with input %p', (testCase) => {
        expect(sumSquares(testCase)).toBe(calculateModifiedSum(testCase));
    });
});