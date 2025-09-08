// Source Code
function prodSigns(arr) {
    if (arr.length === 0) return null;
    const hasZero = arr.includes(0);
    const negativeCount = arr.filter(x => x < 0).length;
    const prod = hasZero ? 0 : Math.pow(-1, negativeCount);
    const sumOfAbs = arr.reduce((acc, i) => acc + Math.abs(i), 0);
    return prod * sumOfAbs;
}

// Transformed Code (Semantically Equivalent)
function calculateSignedSum(numbers) {
    if (!numbers.length) {
        return null;
    }

    const negativeCount = numbers.reduce((count, num) => count + (num < 0 ? 1 : 0), 0);
    const containsZero = numbers.some(num => num === 0);

    const sign = containsZero ? 0 : Math.pow(-1, negativeCount);
    const totalSum = numbers.reduce((sum, num) => sum + Math.abs(num), 0);

    return sign * totalSum;
}

// Test Cases
describe('prodSigns vs calculateSignedSum equivalence tests', () => {
    const testCases = [
        [1, 2, 3],
        [-1, -2, -3],
        [1, -2, 3],
        [0, 1, 2, 3],
        [0, -1, -2, -3],
        [],
        [5, 7, -9, 12],
        [-5, -7, 9, -12],
        [0, 0, 0],
        [1, 1, 1, -1, -1, -1]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(prodSigns(inputArray)).toBe(calculateSignedSum(inputArray));
    });
});