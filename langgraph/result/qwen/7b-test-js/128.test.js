// Source Code
function prodSigns(arr) {
    if (!arr.length) return null;
    const hasZero = arr.includes(0);
    const negativeCount = arr.filter(x => x < 0).length;
    const productSign = hasZero ? 0 : Math.pow(-1, negativeCount);
    const absoluteSum = arr.reduce((acc, val) => acc + Math.abs(val), 0);
    return productSign * absoluteSum;
}

// Transformed Code (Semantically Equivalent)
function calculateSignedSum(arr) {
    if (!arr.length) {
        return null;
    }
    
    const negativeCount = arr.filter(num => num < 0).length;
    const containsZero = arr.some(num => num === 0);
    
    let sign = containsZero ? 0 : Math.pow(-1, negativeCount);
    const totalSum = arr.reduce((acc, num) => acc + Math.abs(num), 0);
    
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