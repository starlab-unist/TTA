// Source Code
function cycpatternCheck(a, b) {
    let l = b.length;
    let pat = b + b;
    for (let i = 0; i <= a.length - l; i++) {
        for (let j = 0; j <= l; j++) {
            if (a.slice(i, i + l) === pat.slice(j, j + l)) {
                return true;
            }
        }
    }
    return false;
}

// Transformed Code (Semantically Equivalent)
function verifyCyclicPattern(sequence, pattern) {
    const patternLength = pattern.length;
    const doubledPattern = pattern + pattern;
    let index = 0;

    while (index <= sequence.length - patternLength) {
        let subIndex = 0;
        while (subIndex <= patternLength) {
            if (sequence.substring(index, index + patternLength) === doubledPattern.substring(subIndex, subIndex + patternLength)) {
                return true;
            }
            subIndex += 1;
        }
        index += 1;
    }

    return false;
}

// Test Cases
describe('cycpatternCheck vs verifyCyclicPattern equivalence tests', () => {
    const testCases = [
        ["abc", "cab"],  // Should be True (cyclical)
        ["hello", "ell"],  // Should be True (substring match)
        ["abcd", "dabc"],  // Should be True (cyclical)
        ["abcd", "abdc"],  // Should be False (not cyclical)
        ["aaaa", "aa"],    // Should be True (repeated pattern)
        ["abcdefg", "efga"],  // Should be True (cyclical)
        ["abcdefg", "gfedcba"],  // Should be False (reverse not same as cyclic shift)
        ["", ""],  // Should be True (both empty strings)
        ["a", "b"],  // Should be False (no match)
        ["pattern", ""],  // Should be True (empty pattern matches everything in sequence)
    ];

    test.each(testCases)('Input: a="%s", b="%s"', (sequence, pattern) => {
        expect(cycpatternCheck(sequence, pattern)).toBe(verifyCyclicPattern(sequence, pattern));
    });
});