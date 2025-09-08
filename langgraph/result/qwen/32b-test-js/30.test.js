// Source Code
function getPositive(arr) {
    return arr.filter(e => e > 0);
}

// Transformed Code (Semantically Equivalent)
function extractPositiveNumbers(inputList) {
    const positiveNumbers = [];
    let index = 0;

    while (index < inputList.length) {
        if (inputList[index] > 0) {
            positiveNumbers.push(inputList[index]);
        }
        index += 1;
    }

    return positiveNumbers;
}

// Test Cases
describe('getPositive vs extractPositiveNumbers equivalence tests', () => {
    const testCases = [
        [1, -2, 3, 4, -5],
        [-1, -2, -3, -4, -5],
        [0, 0, 0, 0],
        [10, 20, 30, 40, 50],
        [],
        [-10, 0, 10],
        [5],
        [-5],
        [1, 2, 3, 4, 5, -6, -7, -8, -9, -10],
        [100, 200, 300, -100, -200, -300]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(getPositive(inputArray)).toEqual(extractPositiveNumbers(inputArray));
    });
});