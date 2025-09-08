// Source Code
function pairsSumToZero(l) {
    for (let i = 0; i < l.length; i++) {
        for (let j = i + 1; j < l.length; j++) {
            if (l[i] + l[j] === 0) {
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
            nextIndex++;
        }
        index++;
    }
    return false;
}

// Test Cases
describe('pairsSumToZero vs checkForZeroSumPairs equivalence tests', () => {
    const testCases = [
        { input: [], expected: false },
        { input: [1, -1], expected: true },
        { input: [2, 3, -2], expected: true },
        { input: [0, 0], expected: true },
        { input: [5, 7, 9], expected: false },
        { input: [-5, -7, -9], expected: false },
        { input: [1, 2, 3, -3], expected: true },
        { input: [10, 20, -10, 30], expected: true },
        { input: [4, 5, 6, 7, 8], expected: false },
        { input: [0, 1, 2, 3, 4, 5, -5], expected: true }
    ];

    test.each(testCases)('Input: %j', ({ input, expected }) => {
        expect(pairsSumToZero(input)).toBe(checkForZeroSumPairs(input));
    });
});