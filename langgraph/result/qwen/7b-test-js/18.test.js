// Source Code
function howManyTimes(string, substring) {
    let times = 0;

    for (let i = 0; i <= string.length - substring.length; i++) {
        if (string.slice(i, i + substring.length) === substring) {
            times++;
        }
    }

    return times;
}

// Transformed Code
function countOccurrences(mainStr, subStr) {
    let occurrenceCount = 0;
    let index = 0;

    while (index <= mainStr.length - subStr.length) {
        if (mainStr.slice(index, index + subStr.length) === subStr) {
            occurrenceCount += 1;
        }
        index += 1;
    }

    return occurrenceCount;
}

// Test Cases
describe('howManyTimes vs countOccurrences equivalence tests', () => {
    const testCases = [
        ["hello", "l"],          // Expected: 2
        ["banana", "na"],        // Expected: 2
        ["aaaa", "aa"],          // Expected: 3
        ["abcde", "f"],          // Expected: 0
        ["mississippi", "issi"], // Expected: 1
        ["abababa", "aba"],      // Expected: 2
        ["", ""],                // Expected: 1 (empty substring in empty string)
        ["a", ""],               // Expected: 2 (empty substring in non-empty string)
        ["hello world", "o w"],  // Expected: 1
        ["abc", "d"]             // Expected: 0
    ];

    test.each(testCases)('Input: "%s", "%s"', (string, substring) => {
        expect(howManyTimes(string, substring)).toBe(countOccurrences(string, substring));
    });
});