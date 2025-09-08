// Source Code
function addElements(arr, k) {
    return arr.slice(0, k).reduce((sum, elem) => {
        const strElem = elem.toString();
        return strElem.length <= 2 ? sum + elem : sum;
    }, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateSumOfSmallNumbers(numbers, count) {
    let total = 0;
    let index = 0;

    while (index < count && index < numbers.length) {
        if (numbers[index].toString().length <= 2) {
            total += numbers[index];
        }
        index += 1;
    }

    return total;
}

// Test Cases
describe('addElements vs calculateSumOfSmallNumbers equivalence tests', () => {
    const testCases = [
        [[1, 10, 100, 1000], 3],
        [[5, 23, 456, 7890], 4],
        [[99, 100, 101, 102], 2],
        [[1, 2, 3, 4, 5], 5],
        [[123, 45, 67, 89, 10], 5],
        [[111, 222, 333, 44, 55], 3],
        [[1, 1, 1, 1, 1], 1],
        [[], 1],
        [[10, 20, 30, 40, 50], 0],
        [[9, 8, 7, 6, 5], 5]
    ];

    testCases.forEach(([arr, k], index) => {
        it(`Test case ${index}`, () => {
            expect(addElements(arr, k)).toBe(calculateSumOfSmallNumbers(arr, k));
        });
    });
});