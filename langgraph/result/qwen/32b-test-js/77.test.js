// Source Code
function isCube(a) {
    a = Math.abs(a);
    const cubeRoot = Math.round(Math.cbrt(a));
    return cubeRoot ** 3 === a;
}

// Transformed Code (Semantically Equivalent)
function checkPerfectCube(number) {
    number = Math.abs(number);
    let cubeRoot = Math.round(Math.cbrt(number));
    return cubeRoot ** 3 === number;
}

// Test Cases
describe('isCube vs checkPerfectCube equivalence tests', () => {
    const testCases = [
        27,     // 3^3
        -27,    // -3^3 but abs is used so it should be treated as 3^3
        64,     // 4^3
        -64,    // -4^3 but abs is used so it should be treated as 4^3
        0,      // 0^3
        1,      // 1^3
        2,      // Not a perfect cube
        -8,     // -2^3 but abs is used so it should be treated as 2^3
        15,     // Not a perfect cube
        125     // 5^3
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(isCube(inputNumber)).toBe(checkPerfectCube(inputNumber));
    });
});