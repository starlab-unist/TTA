// Source Code
function getClosestVowel(word) {
    if (word.length < 3) {
        return "";
    }

    const vowels = new Set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']);
    for (let i = word.length - 2; i > 0; i--) {
        if (vowels.has(word[i])) {
            if (!vowels.has(word[i + 1]) && !vowels.has(word[i - 1])) {
                return word[i];
            }
        }
    }
    return "";
}

// Transformed Code (Semantically Equivalent)
function findNearestIsolatedVowel(word) {
    if (word.length < 3) {
        return "";
    }

    const vowels = new Set("aeiouAEIOU");
    let index = word.length - 3;

    while (index > 0) {
        if (vowels.has(word[index])) {
            if (!vowels.has(word[index + 1]) && !vowels.has(word[index - 1])) {
                return word[index];
            }
        }
        index -= 1;
    }

    return "";
}

// Test Cases
describe('getClosestVowel vs findNearestIsolatedVowel equivalence tests', () => {
    const testCases = [
        "hello",
        "beautiful",
        "sequence",
        "aeiou",
        "bcdfg",
        "aebcdfg",
        "racecar",
        "xylophone",
        "umbrella",
        "algorithm"
    ];

    test.each(testCases)('Input: "%s"', (inputWord) => {
        expect(getClosestVowel(inputWord)).toBe(findNearestIsolatedVowel(inputWord));
    });
});