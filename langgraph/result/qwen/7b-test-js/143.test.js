// Source Code
function wordsInSentence(sentence) {
    let newLst = [];
    for (let word of sentence.split(/\s+/)) { // Corrected split method
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
    return newLst.join(" ");
}

// Transformed Code (Semantically Equivalent)
function filterUniqueLengthWords(sentence) {
    const result = [];
    const terms = sentence.split(/\s+/); // Corrected split method
    for (let i = 0; i < terms.length; i++) {
        let flag = false;
        if (terms[i].length === 1) {
            flag = true;
        }
        let divisor = 2;
        while (divisor < terms[i].length) {
            if (terms[i].length % divisor === 0) {
                flag = true;
                break;
            }
            divisor++;
        }
        if (!flag || terms[i].length === 2) {
            result.push(terms[i]);
        }
    }
    return result.join(" ");
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