// Source Code
function solution(lst) {
    return lst.reduce((sum, x, idx) => {
        return (idx % 2 === 0 && x % 2 === 1) ? sum + x : sum;
    }, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateOddSumAtEvenIndices(numbers) {
    let total = 0;
    let index = 0;
    while (index < numbers.length) {
        if (index % 2 === 0 && numbers[index] % 2 === 1) {
            total += numbers[index];
        }
        index += 1;
    }
    return total;
}

// Test Cases
describe('solution vs calculateOddSumAtEvenIndices equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5],          // Expected output: 9 (1 + 3 + 5)
        [2, 4, 6, 8, 10],         // Expected output: 0
        [1, 3, 5, 7, 9],          // Expected output: 15 (1 + 5 + 9)
        [],                       // Expected output: 0
        [1],                      // Expected output: 1
        [2, 2, 2, 2, 2, 2],       // Expected output: 0
        [1, 1, 1, 1, 1, 1],       // Expected output: 3 (1 + 1 + 1)
        [0, 1, 2, 3, 4, 5, 6],    // Expected output: 9 (1 + 3 + 5)
        [7, 8, 9, 10, 11, 12],    // Expected output: 18 (7 + 9 + 11)
        [13, 14, 15, 16, 17, 18]  // Expected output: 45 (13 + 15 + 17)
    ];

    test.each(testCases.map((testCase, index) => [index, testCase]))(
        'Test case %i: Input: %s',
        (index, inputList) => {
            expect(solution(inputList)).toBe(calculateOddSumAtEvenIndices(inputList));
        }
    );
});