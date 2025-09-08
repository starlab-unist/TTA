// Source Code
function countNums(arr) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) n = -1 * n, neg = -1;
        n = Array.from(String(n), Number);
        n[0] = n[0] * neg;
        return n.reduce((a, b) => a + b, 0);
    }
    return arr.filter(x => digitsSum(x) > 0).length;
}

// Transformed Code (Semantically Equivalent)
function tallyPositiveDigitSums(arr) {
    function computeDigitSum(number) {
        let sign = number < 0 ? -1 : 1;
        let absoluteValue = Math.abs(number);
        let digitList = Array.from(String(absoluteValue), Number);
        digitList[0] *= sign;
        return digitList.reduce((sum, digit) => sum + digit, 0);
    }

    let positiveSumsCount = 0;
    for (let num of arr) {
        if (computeDigitSum(num) > 0) {
            positiveSumsCount++;
        }
    }

    return positiveSumsCount;
}

// Test Cases
describe('countNums vs tallyPositiveDigitSums equivalence tests', () => {
    const testCases = [
        [123, -456, 789], 
        [-111, 222, -333, 444],
        [0, 0, 0],
        [-1, 1, -1, 1],
        [999, -888, 777, -666],
        [1001, 2002, -3003, 4004],
        [-5, 5, -5, 5, -5],
        [10, -20, 30, -40, 50],
        [987654321, -123456789],
        [-12345, 12345, -12345]
    ];

    test.each(testCases)('Input: %j', (inputArray) => {
        expect(countNums(inputArray)).toBe(tallyPositiveDigitSums(inputArray));
    });
});