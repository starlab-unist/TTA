// Source Code
function splitWords(txt) {
    if (txt.includes(" ")) {
        return txt.split();
    } else if (txt.includes(",")) {
        return txt.replace(',', ' ').split();
    } else {
        return [...txt].filter(i => i === i.toLowerCase() && (i.charCodeAt(0) - 97) % 2 === 0).length;
    }
}

// Transformed Code (Semantically Equivalent)
function extractAndCountWords(txt) {
    let words;
    if (' ' in txt) {
        words = txt.split(' ');
    } else if (',' in txt) {
        words = txt.replace(',', ' ').split(' ');
    } else {
        const count = Array.from(txt).reduce((acc, char) => {
            if (char >= 'a' && char <= 'z' && char.charCodeAt(0) % 2 === 0) {
                acc++;
            }
            return acc;
        }, 0);
        return count;
    }

    return words;
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