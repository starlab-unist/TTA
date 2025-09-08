// Source Code
function prodSigns(arr) {
    if (!arr.length) return null;
    let prod = 0;
    if (arr.includes(0)) prod = 0;
    else prod = Math.pow(-1, arr.filter(x => x < 0).length);
    return prod * arr.map(Math.abs).reduce((acc, curr) => acc + curr, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateSignedSum(numbers) {
    if (!numbers.length) {
        return null;
    }

    const negativeCount = numbers.filter(num => num < 0).length;
    const containsZero = numbers.includes(0);

    let sign = 0;
    if (containsZero) {
        sign = 0;
    } else {
        sign = Math.pow(-1, negativeCount);
    }

    const totalSum = numbers.reduce((acc, num) => acc + Math.abs(num), 0);

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