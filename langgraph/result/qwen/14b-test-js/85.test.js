// Source Code
function add(lst) {
    return lst.filter((value, index) => index % 2 !== 0 && value % 2 === 0).reduce((acc, curr) => acc + curr, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateEvenSumAtOddIndices(numbers) {
    let total = 0;
    let index = 1;
    while (index < numbers.length) {
        if (numbers[index] % 2 === 0) {
            total += numbers[index];
        }
        index += 2;
    }
    return total;
}

// Test Cases
describe('add vs calculateEvenSumAtOddIndices equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5, 6],       // Expected output: 6 (2 + 4)
        [10, 15, 20, 25, 30, 35], # Expected output: 0 (no even numbers at odd indices)
        [2, 4, 6, 8, 10, 12],     // Expected output: 20 (4 + 8 + 12)
        [1, 3, 5, 7, 9],          // Expected output: 0 (no even numbers at odd indices)
        [],                       // Expected output: 0 (empty list)
        [0, 0, 0, 0, 0, 0],       // Expected output: 0 (all zeros)
        [1, 2],                   // Expected output: 2
        [1, 2, 3],                // Expected output: 2
        [1, 2, 3, 4],             // Expected output: 6 (2 + 4)
        [1, 2, 3, 4, 5]           // Expected output: 6 (2 + 4)
    ];

    test.each(testCases.map((testCase, index) => [index, testCase]))('Test Case %i: Input: %p', (index, inputList) => {
        expect(add(inputList)).toBe(calculateEvenSumAtOddIndices(inputList));
    });
});