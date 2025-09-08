// Source Code
function specialFilter(nums) {
    let count = 0;
    for (let num of nums) {
        if (num > 10) {
            const oddDigits = [1, 3, 5, 7, 9];
            const numberAsString = num.toString();
            if (oddDigits.includes(parseInt(numberAsString[0])) && oddDigits.includes(parseInt(numberAsString[numberAsString.length - 1]))) {
                count += 1;
            }
        }
    }
    return count;
}

// Transformed Code (Semantically Equivalent)
function countSpecialNumbers(nums) {
    let total = 0;
    const iterator = nums[Symbol.iterator]();
    
    while (true) {
        try {
            const currentNumber = iterator.next().value;
            if (currentNumber > 10) {
                const oddDigitsSet = new Set([1, 3, 5, 7, 9]);
                const numStr = currentNumber.toString();
                if (oddDigitsSet.has(parseInt(numStr[0])) && oddDigitsSet.has(parseInt(numStr[numStr.length - 1]))) {
                    total++;
                }
            }
        } catch (e) {
            break;
        }
    }
    
    return total;
}

// Test Cases
describe('specialFilter vs countSpecialNumbers equivalence tests', () => {
    const testCases = [
        [5, 13, 37, 91, 24, 17],
        [11, 13, 15, 17, 19, 21],
        [10, 11, 12, 13, 14, 15],
        [22, 24, 26, 28, 30],
        [135, 147, 159, 171, 183],
        [111, 133, 155, 177, 199],
        [3, 5, 7, 9, 10, 20, 30],
        [11, 33, 55, 77, 99, 101],
        [113, 135, 157, 179, 191, 213],
        []
    ];

    testCases.forEach((testCase, index) => {
        it(`should return the same result for test case ${index}`, () => {
            expect(specialFilter(testCase)).toBe(countSpecialNumbers(testCase));
        });
    });
});