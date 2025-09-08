// Source Code
function orderByPoints(nums) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) n = -1 * n, neg = -1;
        n = Array.from(String(n), Number);
        n[0] = n[0] * neg;
        return n.reduce((a, b) => a + b, 0);
    }
    return nums.sort((a, b) => digitsSum(a) - digitsSum(b));
}

// Transformed Code (Semantically Equivalent)
function sortNumbersByDigitSum(nums) {
    function calculateWeight(number) {
        let sign = number < 0 ? -1 : 1;
        let absoluteValue = Math.abs(number);
        let digits = Array.from(String(absoluteValue), Number).map((digit, index) => index === 0 ? digit * sign : digit);
        return digits.reduce((acc, digit) => acc + digit, 0);
    }
    
    return nums.sort((a, b) => calculateWeight(a) - calculateWeight(b));
}

// Test Cases
describe('orderByPoints vs sortNumbersByDigitSum equivalence tests', () => {
    const testCases = [
        [123, 321, 213],
        [-12, -21, 12, 21],
        [0, 5, 10, 15],
        [987, 879, 798],
        [-1234, -4321, 1234, 4321],
        [555, 666, 777],
        [-9, -8, -7, -6],
        [100, 200, 300],
        [5, -5, 10, -10],
        [111, -111, 222, -222]
    ];

    testCases.forEach((testCase, index) => {
        it(`should return the same result for test case ${index}`, () => {
            expect(orderByPoints([...testCase])).toEqual(sortNumbersByDigitSum([...testCase]));
        });
    });
});