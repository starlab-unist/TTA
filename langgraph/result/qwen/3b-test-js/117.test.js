// Source Code
function selectWords(s, n) {
    let result = [];
    const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
    
    s.split(' ').forEach(word => {
        let nConsonants = 0;
        for (let i = 0; i < word.length; i++) {
            if (!vowels.has(word[i].toLowerCase())) {
                nConsonants++;
            }
        }
        if (nConsonants === n) {
            result.push(word);
        }
    });
    
    return result;
}

// Transformed Code (Semantically Equivalent)
function filterWordsByConsonantCount(inputString, targetConsonantCount) {
    let selectedWords = [];
    let words = inputString.split(' ');

    for (let i = 0; i < words.length; i++) {
        let word = words[i];
        let consonantCounter = 0;

        for (let j = 0; j < word.length; j++) {
            if ('aeiou'.indexOf(word[j].toLowerCase()) === -1) {
                consonantCounter++;
            }
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

    test.each(testCases)('Input: "%s" with %d consonants', (inputString, targetConsonantCount) => {
        expect(selectWords(inputString, targetConsonantCount)).toEqual(filterWordsByConsonantCount(inputString, targetConsonantCount));
    });
});