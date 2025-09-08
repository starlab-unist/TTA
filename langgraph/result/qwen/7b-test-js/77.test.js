// Source Code
function isCube(a) {
    a = Math.abs(a);
    return Math.pow(Math.round(Math.cbrt(a)), 3) === a;
}

// Transformed Code (Semantically Equivalent)
function isCubeTransformed(a) {
    a = Math.abs(a);
    let cubeRoot = Math.round(Math.pow(a, 1/3));
    return cubeRoot ** 3 === a;
}

// Test Cases
describe('isCube vs isCubeTransformed equivalence tests', () => {
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

    test.each(testCases)('Input: %d', (inputValue) => {
        expect(isCube(inputValue)).toBe(isCubeTransformed(inputValue));
    });
});