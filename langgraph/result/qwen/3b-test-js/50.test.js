// Source Code
function encodeShift(s) {
    return s.split('').map(ch => {
        const shiftedCharCode = ((ch.charCodeAt(0) + 5 - 'a'.charCodeAt(0)) % 26) + 'a'.charCodeAt(0);
        return String.fromCharCode(shiftedCharCode);
    }).join('');
}

function decodeShift(s) {
    return s.split('').map(ch => {
        const shiftedCharCode = ((ch.charCodeAt(0) - 5 - 'a'.charCodeAt(0)) % 26) + 'a'.charCodeAt(0);
        return String.fromCharCode(shiftedCharCode);
    }).join('');
}

// Transformed Code (Semantically Equivalent)
function shiftEncode(inputString) {
    /**
     * Encodes the input string by shifting each character forward by 5 positions in the alphabet.
     */
    let encodedChars = [];
    for (let character of inputString) {
        let shiftedChar = String.fromCharCode(((character.charCodeAt(0) + 5 - "a".charCodeAt(0)) % 26) + "a".charCodeAt(0));
        encodedChars.push(shiftedChar);
    }
    return encodedChars.join('');
}

function shiftDecode(encodedString) {
    let decodedChars = [];
    let index = 0;
    while (index < encodedString.length) {
        let originalChar = String.fromCharCode(((encodedString.charCodeAt(index) - 5 - "a".charCodeAt(0)) % 26) + "a".charCodeAt(0));
        decodedChars.push(originalChar);
        index++;
    }
    return decodedChars.join('');
}

// Test Cases
describe('encodeShift vs shiftEncode equivalence tests', () => {
    const testCases = [
        "abcde",
        "fghij",
        "vwxyz",
        "hello",
        "world",
        "python",
        "unittest",
        "shift",
        "encode",
        "decode"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(encodeShift(inputText)).toBe(shiftEncode(inputText));
    });
});

describe('decodeShift vs shiftDecode equivalence tests', () => {
    const testCases = [
        "abcde",
        "fghij",
        "vwxyz",
        "hello",
        "world",
        "python",
        "unittest",
        "shift",
        "encode",
        "decode"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(decodeShift(inputText)).toBe(shiftDecode(inputText));
    });
});