// Source Code
function largestSmallestIntegers(lst) {
    const negativeNumbers = lst.filter(x => x < 0);
    const positiveNumbers = lst.filter(x => x > 0);

    const smallestNegative = negativeNumbers.length > 0 ? Math.min(...negativeNumbers) : null;
    const largestPositive = positiveNumbers.length > 0 ? Math.max(...positiveNumbers) : null;

    return [largestPositive, smallestNegative];
}

// Transformed Code (Semantically Equivalent)
function findExtremeValues(numbers) {
    const negativeNumbers = numbers.filter(num => num < 0);
    const positiveNumbers = numbers.filter(num => num > 0);

    const maxNegative = negativeNumbers.length ? Math.max(...negativeNumbers) : null;
    const minPositive = positiveNumbers.length ? Math.min(...positiveNumbers) : null;

    return [maxNegative, minPositive];
}

// Test Cases
describe('largestSmallestIntegers vs findExtremeValues equivalence tests', () => {
    const testCases = [
        [1, 2, 3, -1, -2, -3],  // Mixed negatives and positives
        [-5, -4, -3, -2, -1],     // All negatives
        [5, 4, 3, 2, 1],          // All positives
        [0, 0, 0],                // Only zeros
        [],                       // Empty list
        [-10, 0, 10],             // Single negative and positive
        [-1, -2, 0, 2, 1],        // Mixed with zero
        [100],                    // Single positive
        [-100],                   // Single negative
        [1, -1, 2, -2, 3, -3]     // Alternating positives and negatives
    ];

    test.each(testCases)('Input: %p', (inputList) => {
        expect(largestSmallestIntegers(inputList)).toEqual(findExtremeValues(inputList));
    });
});