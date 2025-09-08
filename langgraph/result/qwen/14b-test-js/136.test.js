// Source Code
function largestSmallestIntegers(lst) {
    const smallest = lst.filter(x => x < 0);
    const largest = lst.filter(x => x > 0);
    return (smallest.length > 0 ? Math.max(...smallest) : null, largest.length > 0 ? Math.min(...largest) : null);
}

// Transformed Code (Semantically Equivalent)
function findExtremeValues(numbers) {
    const negativeNumbers = numbers.filter(num => num < 0);
    const positiveNumbers = numbers.filter(num => num > 0);

    const maxNegative = negativeNumbers.length > 0 ? Math.max(...negativeNumbers) : null;
    const minPositive = positiveNumbers.length > 0 ? Math.min(...positiveNumbers) : null;

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

    test.each(testCases)('Input: %p', (inputArray) => {
        const originalResult = largestSmallestIntegers(inputArray);
        const transformedResult = findExtremeValues(inputArray);

        expect(originalResult).toEqual(transformedResult);
    });
});