// Source Code
function removeDuplicates(numbers) {
    const countMap = new Map();
    
    // Count occurrences of each number
    numbers.forEach(number => {
        countMap.set(number, (countMap.get(number) || 0) + 1);
    });

    // Filter numbers that appear only once
    return numbers.filter(number => countMap.get(number) <= 1);
}

// Transformed Code (Semantically Equivalent)
function filterUniqueElements(numList) {
    const countMap = {};
    numList.forEach(num => {
        countMap[num] = (countMap[num] || 0) + 1;
    });
    const uniqueNumbers = numList.filter(num => countMap[num] === 1);
    return uniqueNumbers;
}

// Test Cases
describe('removeDuplicates vs filterUniqueElements equivalence tests', () => {
    const testCases = [
        { input: [1, 2, 2, 3, 4, 4, 5], expected: [1, 3, 5] },
        { input: [10, 20, 20, 30, 30, 30, 40], expected: [10, 40] },
        { input: [1, 1, 1, 1, 1], expected: [] },
        { input: [5, 7, 8, 9, 10], expected: [5, 7, 8, 9, 10] },
        { input: [], expected: [] },
        { input: [123, 456, 789], expected: [123, 456, 789] },
        { input: [1, 2, 3, 4, 5, 1, 2, 3, 4, 5], expected: [] },
        { input: [0, 0, 0, 1, 1, 1, 2, 2, 3], expected: [3] },
        { input: [7, 8, 9, 7, 8, 10], expected: [9, 10] },
        { input: [42], expected: [42] }
    ];

    test.each(testCases)('Input: "%s"', ({ input, expected }) => {
        expect(removeDuplicates(input)).toEqual(filterUniqueElements(input));
    });
});