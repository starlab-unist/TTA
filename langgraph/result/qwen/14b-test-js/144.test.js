// Source Code
function simplify(x, n) {
    const [a, b] = x.split("/");
    const [c, d] = n.split("/");
    const numerator = parseInt(a) * parseInt(c);
    const denom = parseInt(b) * parseInt(d);
    if (numerator / denom === Math.floor(numerator / denom)) {
        return true;
    }
    return false;
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
        ["1/2", "2/4"],    // True: (1*2) / (2*4) = 2/8 = 1/4
        ["5/7", "7/14"],   // False: (5*7) / (7*14) = 35/98 != int(35/98)
        ["1/3", "3/9"],    // True: (1*3) / (3*9) = 3/27 = 1/9
        ["0/1", "5/10"],   // True: (0*5) / (1*10) = 0
        ["1/1", "1/1"],    // True: (1*1) / (1*1) = 1
        ["7/9", "9/18"],   // True: (7*9) / (9*18) = 63/162 = 7/18
        ["2/3", "3/6"],    // False: (2*3) / (3*6) = 6/18 != int(6/18)
        ["10/20", "20/40"],// True: (10*20) / (20*40) = 200/800 = 1/4
        ["5/7", "7/14"],   // False: (5*7) / (7*14) = 35/98 != int(35/98)
        ["5/7", "7/14"]    // False: (5*7) / (7*14) = 35/98 != int(35/98)
    ];

    testCases.forEach(([x, n], index) => {
        it(`Test case ${index}`, () => {
            expect(simplify(x, n)).toBe(checkFractionSimplification(x, n));
        });
    });
});