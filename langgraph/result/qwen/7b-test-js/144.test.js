// Source Code
function simplify(x, n) {
    let [a, b] = x.split("/");
    let [c, d] = n.split("/");
    let numerator = parseInt(a) * parseInt(c);
    let denom = parseInt(b) * parseInt(d);
    if (numerator / denom === Math.floor(numerator / denom)) {
        return true;
    }
    return false;
}

// Transformed Code (Semantically Equivalent)
function checkFractionSimplification(x, n) {
    const [a, b] = x.split('/').map(Number);
    const [c, d] = n.split('/').map(Number);
    const numerator = a * c;
    const denom = b * d;
    return numerator % denom === 0;
}

// Test Cases
describe('simplify vs checkFractionSimplification equivalence tests', () => {
    const testCases = [
        ["1/2", "2/4"],    // True: (1*2) / (2*4) = 1/4
        ["3/4", "4/8"],    // True: (3*4) / (4*8) = 63/162 = 7/18
        ["1/1", "1/1"],    // True: (1*1) / (1*1) = 1
        ["0/1", "5/10"],   // True: (0*5) / (1*10) = 0
        ["2/3", "3/6"],    // False: (2*3) / (3*6) = 6/18 != int(6/18)
        ["10/20", "20/40"],# True: (10*20) / (20*40) = 200/800 = 1/4
        ["1/3", "3/9"],    // True: (1*3) / (3*9) = 3/27 = 1/9
        ["5/7", "7/14"]    // False: (5*7) / (7*14) = 35/98 != int(35/98)
    ];

    testCases.forEach(([x, n], index) => {
        it(`Test case ${index}`, () => {
            expect(simplify(x, n)).toBe(checkFractionSimplification(x, n));
        });
    });
});