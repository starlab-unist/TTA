// Source Code
function isSorted(lst) {
    const countDigit = {};
    for (let i of lst) {
        countDigit[i] = (countDigit[i] || 0) + 1;
    }
    if (Object.values(countDigit).some(count => count > 2)) {
        return false;
    }
    for (let i = 1; i < lst.length; i++) {
        if (lst[i - 1] > lst[i]) {
            return false;
        }
    }
    return true;
}

// Transformed Code (Semantically Equivalent)
function checkSortedSequence(sequence) {
    const digitCount = {};
    for (let number of sequence) {
        digitCount[number] = (digitCount[number] || 0) + 1;
    }

    if (Object.values(digitCount).some(count => count > 2)) {
        return false;
    }

    let index = 1;
    while (index < sequence.length) {
        if (sequence[index - 1] > sequence[index]) {
            return false;
        }
        index++;
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

    test.each(testCases)('Input: %j', (inputArray) => {
        expect(isSorted(inputArray)).toBe(checkSortedSequence(inputArray));
    });
});