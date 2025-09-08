// Source Code
function solve(s) {
    let flg = 0;
    let idx = 0;
    let newStr = s.split('');
    
    for (let i of s) {
        if (/[a-zA-Z]/.test(i)) {
            newStr[idx] = i === i.toUpperCase() ? i.toLowerCase() : i.toUpperCase();
            flg = 1;
        }
        idx++;
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
    let resultChars = Array.from(inputString);
    for (let char of inputString) {
        if (char.match(/[a-zA-Z]/)) {
            resultChars[position] = char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase();
            modified = true;
        }
        position++;
    }
    let transformedString = resultChars.join('');
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
        expect(solve(inputText)).toBe(transformString(inputText));
    });
});