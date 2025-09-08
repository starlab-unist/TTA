// Source Code
function simplify(x, n) {
    const [a, b] = x.split("/");
    const [c, d] = n.split("/");
    const numerator = parseInt(a) * parseInt(c);
    const denom = parseInt(b) * parseInt(d);
    return numerator / denom === Math.floor(numerator / denom);
}

// Transformed Code (Semantically Equivalent)
function checkFractionSimplification(fraction1, fraction2) {
    const [num1, denom1] = fraction1.split('/').map(Number);
    const [num2, denom2] = fraction2.split('/').map(Number);
    const resultNumerator = num1 * num2;
    const resultDenominator = denom1 * denom2;
    return resultNumerator % resultDenominator === 0;
}

// Test Cases
describe('simplify vs checkFractionSimplification equivalence tests', () => {
    const testCases = [
        ["1/2", "2/4"],    // True: (1*2) / (2*4) = 1/4
        ["3/4", "9/12"],   // True: (3*9) / (4*12) = 27/48 = 9/16
        ["1/1", "1/1"],    // True: (1*1) / (1*1) = 1
        ["0/1", "5/10"],   // True: (0*5) / (1*10) = 0
        ["2/3", "3/6"],    // False: (2*3) / (3*6) = 6/18 != int(6/18)
        ["10/20", "20/40"],// True: (10*20) / (20*40) = 200/800 = 1/4
        ["1/3", "3/9"],    // True: (1*3) / (3*9) = 3/27 = 1/9
        ["5/7", "7/14"]    // False: (5*7) / (7*14) = 35/98 != int(35/98)
    ];

    testCases.forEach(([fraction1, fraction2], index) => {
        it(`Test case ${index}`, () => {
            expect(simplify(fraction1, fraction2)).toBe(checkFractionSimplification(fraction1, fraction2));
        });
    });
});