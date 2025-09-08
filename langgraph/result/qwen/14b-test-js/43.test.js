// Source Code
function pairsSumToZero(arr) {
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] === 0) {
                return true;
            }
        }
    }
    return false;
}

// Transformed Code (Semantically Equivalent)
function checkForZeroSumPairs(numbers) {
    let index = 0;
    while (index < numbers.length) {
        const currentNumber = numbers[index];
        let nextIndex = index + 1;
        while (nextIndex < numbers.length) {
            if (currentNumber + numbers[nextIndex] === 0) {
                return true;
            }
            nextIndex += 1;
        }
        index += 1;
    }
    return false;
}

// Test Cases
describe('pairsSumToZero vs checkForZeroSumPairs equivalence tests', () => {
    const testCases = [
        [[], false],
        [[1, -1], true],
        [[2, 3, -2], true],
        [[0, 0], true],
        [[5, 7, 9], false],
        [[-5, -7, -9], false],
        [[1, 2, 3, -3], true],
        [[10, 20, -10, 30], true],
        [[4, 5, 6, 7, 8], false],
        [[0, 1, 2, 3, 4, 5, -5], true]
    ];

    test.each(testCases)('Input: "%s"', (inputArray, expectedOutput) => {
        expect(pairsSumToZero(inputArray)).toBe(checkForZeroSumPairs(inputArray));
    });
});