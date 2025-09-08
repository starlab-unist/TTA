// Source Code
function triplesSumToZero(arr) {
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            for (let k = j + 1; k < arr.length; k++) {
                if (arr[i] + arr[j] + arr[k] === 0) {
                    return true;
                }
            }
        }
    }
    return false;
}

// Transformed Code (Semantically Equivalent)
function checkForZeroSumTriplets(numbers) {
    const length = numbers.length;
    let indexI = 0;
    
    while (indexI < length) {
        let indexJ = indexI + 1;
        while (indexJ < length) {
            let indexK = indexJ + 1;
            while (indexK < length) {
                if (numbers[indexI] + numbers[indexJ] + numbers[indexK] === 0) {
                    return true;
                }
                indexK += 1;
            }
            indexJ += 1;
        }
        indexI += 1;
    }
    
    return false;
}

// Test Cases
describe('triplesSumToZero vs checkForZeroSumTriplets equivalence tests', () => {
    const testCases = [
        [1, 2, -3],          // Simple case with sum zero
        [-1, 0, 1],          // Another simple case with sum zero
        [1, 2, 3],           // No triplets sum to zero
        [0, 0, 0],           // All elements are zero
        [1, -1, 2, -2, 3],   // Multiple pairs but no triplet sums to zero
        [-5, 2, 3, 4, 1],    // Triplet (-5, 2, 3) sums to zero
        [-10, 1, 3, 6, 7],   // Triplet (1, 3, -4) doesn't exist but others do not sum to zero
        [5, 5, 5, -15],      // Triplet (5, 5, -15) sums to zero
        [-2, 0, 2, 0],       // Multiple triplets with zeros and non-zeros
        []                   // Empty list should return False
    ];

    testCases.forEach((testCase, index) => {
        it(`Test case ${index}`, () => {
            expect(triplesSumToZero(testCase)).toBe(checkForZeroSumTriplets(testCase));
        });
    });
});