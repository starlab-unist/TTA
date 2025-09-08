// Source Code
function countNums(arr) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        n = Array.from(String(n), Number);
        n[0] = n[0] * neg;
        return n.reduce((acc, val) => acc + val, 0);
    }
    return arr.map(digitsSum).filter(x => x > 0).length;
}

// Transformed Code (Semantically Equivalent)
function tallyPositiveDigitSums(numbers) {
    function computeDigitSum(number) {
        const sign = number < 0 ? -1 : 1;
        const absoluteValue = Math.abs(number);
        const digitList = String(absoluteValue).split('').map(Number);
        digitList[0] *= sign;
        return digitList.reduce((sum, digit) => sum + digit, 0);
    }

    let positiveSumsCount = 0;
    for (let num of numbers) {
        if (computeDigitSum(num) > 0) {
            positiveSumsCount += 1;
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

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(countNums(inputArray)).toBe(tallyPositiveDigitSums(inputArray));
    });
});