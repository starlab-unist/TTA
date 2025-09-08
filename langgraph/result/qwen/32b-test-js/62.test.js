// Source Code
function derivative(xs) {
    return xs.map((x, i) => i * x).slice(1);
}

// Transformed Code (Semantically Equivalent)
function computeDerivative(coefficients) {
    const result = [];
    let index = 1;
    while (index < coefficients.length) {
        result.push(index * coefficients[index]);
        index += 1;
    }
    return result;
}

// Test Cases
describe('derivative vs computeDerivative equivalence tests', () => {
    const testCases = [
        [3, 1, 2, 4],       // Expected output: [1, 4, 12]
        [0, 5, 0, 7],       // Expected output: [5, 0, 21]
        [1, 3, 5, 7, 9],    // Expected output: [3, 10, 21, 36]
        [2, 0, 0, 0],       // Expected output: [0, 0, 0]
        [10, 20, 30],       // Expected output: [20, 60]
        [5],                // Expected output: []
        [],                 // Expected output: []
        [1, -1, 1, -1],     // Expected output: [-1, 2, -3]
        [0, 0, 0, 0, 0],    // Expected output: [0, 0, 0, 0]
        [7, 6, 5, 4, 3, 2]  // Expected output: [6, 10, 12, 12, 10]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(derivative(inputArray)).toEqual(computeDerivative(inputArray));
    });
});