// Source Code
function isSorted(lst) {
    const countDigit = {};
    lst.forEach(i => {
        countDigit[i] = (countDigit[i] || 0) + 1;
    });
    if (lst.some(i => countDigit[i] > 2)) {
        return false;
    }
    if (lst.every((_, i) => i === 0 || lst[i - 1] <= lst[i])) {
        return true;
    } else {
        return false;
    }
}

// Transformed Code (Semantically Equivalent)
function checkSortedSequence(sequence) {
    const digitCount = {};
    for (const num of sequence) {
        digitCount[num] = (digitCount[num] || 0) + 1;
    }
    
    for (const num in digitCount) {
        if (digitCount[num] > 2) {
            return false;
        }
    }
    
    let index = 1;
    while (index < sequence.length) {
        if (sequence[index - 1] > sequence[index]) {
            return false;
        }
        index += 1;
    }
    
    return true;
}

// Test Cases
describe('isSorted vs checkSortedSequence equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5],
        [5, 4, 3, 2, 1],
        [1, 1, 2, 2, 3, 3],
        [1, 1, 1, 2, 3],
        [1],
        [],
        [1, 2, 2, 3, 4, 5, 5],
        [10, 9, 8, 7, 6, 5],
        [1, 2, 3, 3, 3, 4, 5],
        [1, 2, 3, 4, 5, 5, 5]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(isSorted(inputArray)).toBe(checkSortedSequence(inputArray));
    });
});