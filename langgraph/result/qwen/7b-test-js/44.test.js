// Source Code
function changeBase(x, base) {
    let ret = "";
    while (x > 0) {
        ret = (x % base).toString() + ret;
        x = Math.floor(x / base);
    }
    return ret;
}

// Transformed Code (Semantically Equivalent)
function convertToBase(number, targetBase) {
    let result = "";
    while (number > 0) {
        const remainder = number % targetBase;
        result = remainder.toString() + result;
        number = Math.floor(number / targetBase);
    }
    return result;
}

// Test Cases
describe('changeBase vs convertToBase equivalence tests', () => {
    const testCases = [
        [10, 2],   // Binary representation of 10 is 1010
        [255, 16], // Hexadecimal representation of 255 is ff
        [100, 10], // Decimal representation of 100 is 100
        [7, 3],    // Base 3 representation of 7 is 21
        [0, 5],    // Any base representation of 0 is 0
        [1, 2],    // Binary representation of 1 is 1
        [9, 4],    // Base 4 representation of 9 is 21
        [31, 8],   // Octal representation of 31 is 37
        [64, 2],   // Binary representation of 64 is 1000000
        [81, 9]    // Base 9 representation of 81 is 100
    ];

    test.each(testCases)('Input: number=%d, base=%d', (number, base) => {
        expect(changeBase(number, base)).toBe(convertToBase(number, base));
    });
});