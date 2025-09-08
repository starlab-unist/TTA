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

// Transformed Code
function findNearestIsolatedVowel(sequence) {
    if (sequence.length < 3) {
        return "";
    }

    const vowelSet = new Set(["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]);
    let index = sequence.length - 3;

    while (index > 0) {
        if (vowelSet.has(sequence[index])) {
            if (!vowelSet.has(sequence[index + 1]) && !vowelSet.has(sequence[index - 1])) {
                return sequence[index];
            }
        }
        index--;
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

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(getClosestVowel(inputText)).toBe(findNearestIsolatedVowel(inputText))
    });
});