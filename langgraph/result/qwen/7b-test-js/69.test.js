// Source Code
function search(arr) {
    let maxVal = Math.max(...arr);
    let freq = new Array(maxVal + 1).fill(0);

    for (let i of arr) {
        freq[i]++;
    }

    let ans = -1;
    for (let i = 1; i < freq.length; i++) {
        if (freq[i] >= i) {
            ans = i;
        }
    }

    return ans;
}

// Transformed Code (Semantically Equivalent)
function findMaxFrequencyIndex(lst) {
    const maxValue = Math.max(...lst);
    const frequencyArray = new Array(maxValue + 1).fill(0);

    for (let i = 0; i < lst.length; i++) {
        frequencyArray[lst[i]] += 1;
    }

    let result = -1;
    let index = 1;
    while (index < frequencyArray.length) {
        if (frequencyArray[index] >= index) {
            result = index;
        }
        index += 1;
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