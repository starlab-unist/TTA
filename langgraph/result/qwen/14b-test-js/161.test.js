// Source Code
function solve(s) {
    let flg = 0;
    let idx = 0;
    let newStr = s.split('');
    
    for (let i of s) {
        if (/[a-zA-Z]/.test(i)) {
            newStr[idx] = i === i.toLowerCase() ? i.toUpperCase() : i.toLowerCase();
            flg = 1;
        }
        idx += 1;
    }
    
    s = newStr.join('');
    
    if (flg === 0) {
        return s.split('').reverse().join('');
    }
    
    return s;
}

// Transformed Code (Semantically Equivalent)
function transformString(inputString) {
    let modified = false;
    let position = 0;
    let resultChars = inputString.split('');

    for (let char of inputString) {
        if (/[a-zA-Z]/.test(char)) {
            resultChars[position] = char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase();
            modified = true;
        }
        position += 1;
    }

    const transformedString = resultChars.join('');
    if (!modified) {
        return transformedString.split('').reverse().join('');
    }
    return transformedString;
}

// Test Cases
describe('solve vs transformString equivalence tests', () => {
    const testCases = [
        "Hello World",
        "Python3.8",
        "1234567890",
        "!@#$%^&*()",
        "aBcDeFgHiJ",
        "ABCdef123",
        "No Change 123",
        "SWAPcase",
        "",
        " ",
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(solve(inputText)).toBe(transformString(inputText))
    });
});