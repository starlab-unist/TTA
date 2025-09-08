// Source Code
function wordsString(s) {
    if (!s) {
        return [];
    }

    let sList = [];

    for (let letter of s) {
        if (letter === ',') {
            sList.push(' ');
        } else {
            sList.push(letter);
        }
    }

    sList = sList.join('');
    return sList.split(/\s+/).filter(word => word.length > 0);
}

// Transformed Code
function processText(inputString) {
    if (!inputString) {
        return [];
    }

    const processedChars = [];

    let index = 0;
    while (index < inputString.length) {
        const char = inputString[index];
        if (char === ',') {
            processedChars.push(' ');
        } else {
            processedChars.push(char);
        }
        index += 1;
    }

    const processedString = processedChars.join('');
    return processedString.split(/\s+/).filter(word => word.length > 0); // Added filter to match the source code behavior
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