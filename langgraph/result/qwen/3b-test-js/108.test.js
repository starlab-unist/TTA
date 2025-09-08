// Source Code
function countNums(arr) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) n, neg = -1 * n, -1;
        n = n.toString().split('').map(Number);
        n[0] *= neg;
        return n.reduce((acc, val) => acc + val, 0);
    }

    return arr.filter(num => num > 0).map(digitsSum).length;
}

// Transformed Code (Semantically Equivalent)
function tallyPositiveDigitSums(numbers) {
    function computeDigitSum(number) {
        let sign = number < 0 ? -1 : 1;
        let absoluteValue = Math.abs(number);
        let digitList = [];
        
        while (absoluteValue > 0) {
            digitList.push(absoluteValue % 10);
            absoluteValue = Math.floor(absoluteValue / 10);
        }
        
        digitList[0] *= sign;
        return digitList.reduce((sum, digit) => sum + digit, 0);
    }

    let positiveSumsCount = 0;
    for (let num of numbers) {
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