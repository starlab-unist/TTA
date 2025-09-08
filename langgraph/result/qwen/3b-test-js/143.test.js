// Source Code
function wordsInSentence(sentence) {
    let newLst = [];
    const words = sentence.split(' ');

    for (let word of words) {
        let flg = 0;
        if (word.length === 1) {
            flg = 1;
        }
        for (let i = 2; i < word.length; i++) {
            if (word.length % i === 0) {
                flg = 1;
            }
        }
        if (flg === 0 || word.length === 2) {
            newLst.push(word);
        }
    }

    return newLst.join(' ');
}

// Transformed Code (Semantically Equivalent)
function filterUniqueLengthWords(phrase) {
    const result = [];
    const terms = phrase.split(' ');

    for (let i = 0; i < terms.length; i++) {
        let flag = false;
        const term = terms[i];

        if (term.length === 1) {
            flag = true;
        }

        let divisor = 2;
        while (divisor < term.length) {
            if (term.length % divisor === 0) {
                flag = true;
                break;
            }
            divisor += 1;
        }

        if (!flag || term.length === 2) {
            result.push(term);
        }
    }

    return result.join(' ');
}

// Test Cases
describe('wordsInSentence vs filterUniqueLengthWords equivalence tests', () => {
    const testCases = [
        "hello world",
        "a bb ccc dddd eeeee fffffff",
        "prime number test",
        "two three five seven eleven",
        "abc def ghi jkl mno pqr stu vwx yz",
        "one two one two",
        "x y z",
        "ab cd ef gh ij kl mn op qr st uv wx yz",
        "",
        "a"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(wordsInSentence(inputText)).toBe(filterUniqueLengthWords(inputText));
    });
});