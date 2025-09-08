// Source Code
function splitWords(txt) {
    if (txt.includes(" ")) {
        return txt.split(" ");
    } else if (txt.includes(",")) {
        return txt.replace(',', ' ').split();
    } else {
        return txt.split('').filter(char => char.toLowerCase().charCodeAt(0) % 2 === 0).length;
    }
}

// Transformed Code (Semantically Equivalent)
function extractAndCountWords(inputText) {
    if (inputText.includes(' ')) {
        const wordList = inputText.split(' ');
        return wordList; // Added return statement
    } else if (inputText.includes(',')) {
        const wordList = inputText.replace(',', ' ').split(' ');
        return wordList; // Added return statement
    } else {
        const count = Array.from(inputText).reduce((acc, char) => {
            if (char.toLowerCase().charCodeAt(0) % 2 === 0 && char.toLowerCase() !== char.toUpperCase()) {
                acc++;
            }
            return acc;
        }, 0);
        return count;
    }

}

// Test Cases
describe('splitWords vs extractAndCountWords equivalence tests', () => {
    const testCases = [
        "hello world",
        "apple,banana,cherry",
        "one,two three",
        "abcdefg",
        "hijklmno",
        "pqrstuvw",
        "xyz",
        "123456",
        "",
        "a,b,c,d,e,f,g,h,i,j"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(splitWords(inputText)).toStrictEqual(extractAndCountWords(inputText))
    });
});