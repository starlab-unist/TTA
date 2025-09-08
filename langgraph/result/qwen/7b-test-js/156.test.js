// Source Code
function intToMiniRoman(number) {
    const num = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000];
    const sym = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"];
    let i = 12;
    let res = '';
    while (number > 0) {
        const div = Math.floor(number / num[i]);
        number %= num[i];
        while (div > 0) {
            res += sym[i];
            div--;
        }
        i--;
    }
    return res.toLowerCase();
}

// Transformed Code (Semantically Equivalent)
function convertIntegerToMinimalRoman(value) {
    const numeralValues = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000];
    const romanSymbols = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"];
    let index = numeralValues.length - 1;
    let result = "";
    while (value > 0) {
        const quotient = Math.floor(value / numeralValues[index]);
        value %= numeralValues[index];
        while (quotient > 0) {
            result += romanSymbols[index];
            quotient -= 1;
        }
        index -= 1;
    }
    return result.toLowerCase();
}

// Test Cases
describe('intToMiniRoman vs convertIntegerToMinimalRoman', () => {

    const testCases = [
        [1, "i"],
        [4, "iv"],
        [9, "ix"],
        [58, "lviii"],
        [1994, "mcmxciv"],
        [3999, "mmmcmxcix"],
        [1000, "m"],
        [500, "d"],
        [100, "c"],
        [10, "x"]
    ];

    testCases.forEach(([input, expectedOutput], index) => {
        it(`Test case ${index + 1}: Input (${input}) should match output (${expectedOutput})`, () => {
            expect(intToMiniRoman(input)).toBe(expectedOutput);
            expect(convertIntegerToMinimalRoman(input)).toBe(expectedOutput);
        });
    });

});