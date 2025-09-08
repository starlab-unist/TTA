// Source Code
function removeDuplicates(numbers) {
    const counts = {};
    numbers.forEach(number => {
        counts[number] = (counts[number] || 0) + 1;
    });
    return numbers.filter(number => counts[number] <= 1);
}

// Transformed Code (Semantically Equivalent)
const filterUniqueElements = (numbers) => {
    const countMap = {};
    numbers.forEach((num) => {
        countMap[num] = (countMap[num] || 0) + 1;
    });
    const uniqueNumbers = numbers.filter((num) => countMap[num] === 1);
    return uniqueNumbers;
};

// Test Cases
describe('removeDuplicates vs filterUniqueElements equivalence tests', () => {
    const testCases = [
        [1, 2, 2, 3, 4, 4, 5],
        [10, 20, 20, 30, 30, 30, 40],
        [1, 1, 1, 1, 1],
        [5, 7, 8, 9, 10],
        [],
        [123, 456, 789],
        [1, 2, 3, 4, 5, 1, 2, 3, 4, 5],
        [0, 0, 0, 1, 1, 1, 2, 2, 3],
        [7, 8, 9, 7, 8, 10],
        [42]
    ];

    const expectedOutputs = [
        [1, 3, 5],
        [10, 40],
        [],
        [5, 7, 8, 9, 10],
        [],
        [123, 456, 789],
        [],
        [3],
        [9, 10],
        [42]
    ];

    test.each(testCases.map((testCase, index) => [testCase, expectedOutputs[index]]))('Input: %s', (inputNumbers, expectedOutput) => {
        expect(removeDuplicates(inputNumbers)).toEqual(filterUniqueElements(inputNumbers));
        expect(removeDuplicates(inputNumbers)).toEqual(expectedOutput);
    });
});