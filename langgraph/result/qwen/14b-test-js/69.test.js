// Source Code
function search(lst) {
    const maxVal = Math.max(...lst);
    const frq = new Array(maxVal + 1).fill(0);

    for (const i of lst) {
        frq[i]++;
    }

    let ans = -1;
    for (let i = 1; i < frq.length; i++) {
        if (frq[i] >= i) {
            ans = i;
        }
    }

    return ans;
}

// Transformed Code (Semantically Equivalent)
function findMaxFrequencyIndex(numbers) {
    const maxValue = Math.max(...numbers);
    const frequencyArray = new Array(maxValue + 1).fill(0);

    for (let number of numbers) {
        frequencyArray[number]++;
    }

    let result = -1;
    let index = 1;
    while (index < frequencyArray.length) {
        if (frequencyArray[index] >= index) {
            result = index;
        }
        index++;
    }

    return result;
}

// Test Cases
describe('search vs findMaxFrequencyIndex equivalence tests', () => {
    const testCases = [
        [1, 2, 2, 3, 3, 3],
        [4, 5, 6, 7, 8, 9, 10],
        [1, 1, 1, 1, 1],
        [2, 2, 3, 3, 4, 4, 4, 4],
        [1, 2, 3, 4, 5],
        [10, 9, 8, 7, 6, 5, 4, 3, 2, 1],
        [1, 1, 2, 2, 2, 3, 3, 3, 3],
        [5, 5, 5, 5, 5, 5],
        [1],
        []
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(search(inputArray)).toBe(findMaxFrequencyIndex(inputArray));
    });
});