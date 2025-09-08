// Source Code
function selectWords(s, n) {
    const result = [];
    const words = s.split(' '); // Corrected to split by space
    for (const word of words) {
        let nConsonants = 0;
        for (let i = 0; i < word.length; i++) {
            if (!["a", "e", "i", "o", "u"].includes(word[i].toLowerCase())) {
                nConsonants++;
            }
        }
        if (nConsonants === n) {
            result.push(word);
        }
    }
    return result;
}

// Transformed Code (Semantically Equivalent)
function filterWordsByConsonantCount(inputString, targetConsonantCount) {
    const selectedWords = [];
    const words = inputString.split(' '); // Corrected to split by space

    for (const word of words) {
        let consonantCounter = 0;
        let index = 0;
        while (index < word.length) {
            if (!"aeiou".includes(word[index].toLowerCase())) {
                consonantCounter += 1;
            }
            index += 1;
        }

        if (consonantCounter === targetConsonantCount) {
            selectedWords.push(word);
        }
    }

    return selectedWords;
}

// Test Cases
describe('selectWords vs filterWordsByConsonantCount equivalence tests', () => {
    const testCases = [
        ["hello world", 3],
        ["this is a test", 2],
        ["consonants and vowels", 4],
        ["python programming", 5],
        ["simple words", 1],
        ["", 0],
        ["a e i o u", 0],
        ["bcd fgh jkl", 3],
        ["same same same", 3],
        ["different words here", 4]
    ];

    test.each(testCases)('Input: "%s" with %d consonants', (inputText, targetConsonantCount) => {
        expect(selectWords(inputText, targetConsonantCount)).toEqual(filterWordsByConsonantCount(inputText, targetConsonantCount));
    });
});