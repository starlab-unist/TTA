// Source Code
function smallestChange(arr) {
    let ans = 0;
    for (let i = 0; i < Math.floor(arr.length / 2); i++) {
        if (arr[i] !== arr[arr.length - i - 1]) {
            ans += 1;
        }
    }
    return ans;
}

// Transformed Code (Semantically Equivalent)
function minimalAdjustments(sequence) {
    let adjustmentsNeeded = 0;
    let index = 0;
    while (index < sequence.length / 2) {
        if (sequence[index] !== sequence[sequence.length - index - 1]) {
            adjustmentsNeeded += 1;
        }
        index += 1;
    }
    return adjustmentsNeeded;
}

// Test Cases
describe('smallestChange vs minimalAdjustments equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 2, 1],       // Palindrome with odd length
        [1, 2, 3, 4, 5],       // Not a palindrome
        ['a', 'b', 'c', 'b', 'a'], // Palindrome with odd length and strings
        [1, 1, 1, 1, 1],       // All elements are the same
        [1, 2, 2, 1],          // Palindrome with even length
        [1, 2, 3],             // Not a palindrome
        [],                    // Empty list
        [1],                   // Single element
        [1, 2],                // Not a palindrome
        [1, 2, 3, 4]           // Not a palindrome
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(smallestChange(inputArray)).toBe(minimalAdjustments(inputArray));
    });
});