// Source Code
function simplify(x, n) {
    const [a, b] = x.split("/");
    const [c, d] = n.split("/");
    const numerator = parseInt(a) * parseInt(c);
    const denom = parseInt(b) * parseInt(d);
    if (numerator / denom === parseInt(numerator / denom)) {
        return true;
    }
    return false;
}

console.log(simplify("2/3", "4/6")); // Output: true

// Transformed Code (Semantically Equivalent)
function checkFractionSimplification(fraction1, fraction2) {
    const [num1, denom1] = fraction1.split('/').map(Number);
    const [num2, denom2] = fraction2.split('/').map(Number);
    const numerator = num1 * num2;
    const denominator = denom1 * denom2;
    return numerator % denominator === 0;
}

// Test Cases
describe('simplify vs checkFractionSimplification equivalence tests', () => {
    const testCases = [
        ["1/3", "3/9", true],
        ["5/7", "7/14", false],
        ["2/3", "3/6", false],
        ["10/20", "20/40", true],
        ["1/1", "1/1", true],
        ["0/1", "5/10", true],
        ["7/9", "9/18", true],
        ["5/7", "7/14", false],
        ["1/3", "3/9", true],
        ["2/3", "3/6", false]
    ];

    testCases.forEach(([fraction1, fraction2, expected], index) => {
        it(`Test Case ${index}`, () => {
            expect(simplify(fraction1, fraction2)).toBe(expected);
            expect(checkFractionSimplification(fraction1, fraction2)).toBe(expected);
        });
    });
});