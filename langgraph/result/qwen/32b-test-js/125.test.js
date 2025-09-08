// Source Code
function splitWords(txt) {
    if (txt.includes(" ")) {
        return txt.split(" ");
    } else if (txt.includes(",")) {
        return txt.replace(/,/g, ' ').split(" ");
    } else {
        return [...txt].filter(i => i >= 'a' && i <= 'z' && i.charCodeAt(0) % 2 === 0).length;
    }
}

// Transformed Code (Semantically Equivalent)
function extractAndCountWords(inputText) {
    let wordList;
    if (inputText.includes(' ')) {
        wordList = inputText.split(/\s+/);
    } else if (inputText.includes(',')) {
        wordList = inputText.replace(/,/g, ' ').split(/\s+/);
    } else {
        const count = [...inputText].reduce((acc, char) => {
            return acc + (char >= 'a' && char <= 'z' && char.charCodeAt(0) % 2 === 0 ? 1 : 0);
        }, 0);
        return count;
    }

    return wordList;
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
        expect(splitWords(inputText)).toEqual(extractAndCountWords(inputText));
    });
});