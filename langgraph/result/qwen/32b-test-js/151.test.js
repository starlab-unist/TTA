// Source Code
function doubleTheDifference(lst) {
    return lst.reduce((sum, i) => {
        if (i > 0 && i % 2 !== 0 && !String(i).includes('.')) {
            return sum + i ** 2;
        }
        return sum;
    }, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateModifiedSum(numbers) {
    let total = 0;
    for (let num of numbers) {
        if (num > 0 && num % 2 !== 0 && Number.isInteger(num)) {
            total += Math.pow(num, 2);
        }
    }
    return total;
}

// Test Cases
describe('doubleTheDifference vs calculateModifiedSum equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5],         // Mixed positive odd/even integers
        [-1, -3, -5, 0, 2, 4],   // Negative numbers and zero
        [7, 11, 13, 17],         // Only positive odd integers
        [8, 10, 12, 14],         // Only positive even integers
        [1.5, 3.5, 5.5],         // Floating point numbers
        [],                      // Empty list
        [1, 1.1, 3, 3.3, 5, 5.5],// Mixed integers and floats
        [21, 23, 25, 0, -27],    // Positive odd integers with zero and negative
        [9, 8, 7, 6, 5, 4, 3, 2, 1], // Descending order mixed odd/even integers
        [0]                      // Single element zero
    ];

    test.each(testCases)('Input: %p', (inputList) => {
        expect(doubleTheDifference(inputList)).toBe(calculateModifiedSum(inputList));
    });
});