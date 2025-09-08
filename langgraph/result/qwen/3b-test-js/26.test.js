// Source Code
function removeDuplicates(numbers) {
    const count = {};
    numbers.forEach(num => {
        count[num] = (count[num] || 0) + 1;
    });
    return numbers.filter(num => count[num] <= 1);
}

// Transformed Code (Semantically Equivalent)
function filterUniqueElements(numList) {
    const countMap = new Map();
    numList.forEach(num => {
        countMap.set(num, (countMap.get(num) || 0) + 1);
    });
    const uniqueNumbers = numList.filter(num => countMap.get(num) === 1);
    return uniqueNumbers;
}

// Test Cases
describe('removeDuplicates vs filterUniqueElements equivalence tests', () => {
    const testCases = [
        [[1, 2, 2, 3, 4, 4, 5], [1, 3, 5]],
        [[10, 20, 20, 30, 30, 30, 40], [10, 40]],
        [[1, 1, 1, 1, 1], []],
        [[5, 7, 8, 9, 10], [5, 7, 8, 9, 10]],
        [[], []],
        [[123, 456, 789], [123, 456, 789]],
        [[1, 2, 3, 4, 5, 1, 2, 3, 4, 5], []],
        [[0, 0, 0, 1, 1, 1, 2, 2, 3], [3]],
        [[7, 8, 9, 7, 8, 10], [9, 10]],
        [[42], [42]]
    ];

    test.each(testCases)('Input: %j', (inputArray, expectedOutput) => {
        expect(removeDuplicates(inputArray)).toEqual(filterUniqueElements(inputArray));
    });
});