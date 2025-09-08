// Source Code
function wordsString(s) {
    if (!s) {
        return [];
    }

    let sList = [];

    for (let i = 0; i < s.length; i++) {
        if (s[i] === ',') {
            sList.push(' ');
        } else {
            sList.push(s[i]);
        }
    }

    sList = sList.join('');
    return sList.split();
}

// Transformed Code (Semantically Equivalent)
function processText(s) {
    if (!s) {
        return [];
    }

    let sList = [];

    let index = 0;
    while (index < s.length) {
        let char = s[index];
        if (char === ',') {
            sList.push(' ');
        } else {
            sList.push(char);
        }
        index += 1;
    }

    let processedString = sList.join('');
    return processedString.split();
}

// Test Cases
describe('wordsString vs processText equivalence tests', () => {
    const testCases = [
        "Hello,world",
        "Python,is,great!",
        "OpenAI,ChatGPT",
        "This,is,a,test,string",
        "No commas here",
        ",Leading and trailing,",
        "Multiple,,,commas,,here",
        "",
        " ",
        "OneWord"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(wordsString(inputText)).toEqual(processText(inputText));
    });
});