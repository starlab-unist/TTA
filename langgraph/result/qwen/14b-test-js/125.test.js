// Source Code
function splitWords(txt) {
    if (txt.includes(" ")) {
        return txt.split(" ");
    } else if (txt.includes(",")) {
        return txt.replace(',', ' ').split(" ");
    } else {
        return Array.from(txt).filter(i => i >= 'a' && i <= 'z' && i.charCodeAt(0) % 2 === 0).length;
    }
}

// Transformed Code (Semantically Equivalent)
function extractAndCountWords(inputText) {
    if (inputText.includes(' ')) {
        const wordList = inputText.split(' ');
        return wordList;
    } else if (inputText.includes(',')) {
        const wordList = inputText.replace(',', ' ').split(' ');
        return wordList;
    } else {
        let count = 0;
        for (let char of inputText) {
            if (char >= 'a' && char <= 'z' && char.charCodeAt(0) % 2 === 0) {
                count++;
            }
        }
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
        expect(splitWords(inputText)).toEqual(extractAndCountWords(inputText))
    });
});