// Source Code
function isSorted(arr) {
    const countDigit = arr.reduce((acc, num) => {
        acc[num] = (acc[num] || 0) + 1;
        return acc;
    }, {});

    if (Object.values(countDigit).some(count => count > 2)) {
        return false;
    }

    for (let i = 1; i < arr.length; i++) {
        if (arr[i - 1] > arr[i]) {
            return false;
        }
    }

    return true;
}

// Transformed Code (Semantically Equivalent)
function checkSortedSequence(sequence) {
    const digitCount = {};
    for (const num of sequence) {
        digitCount[num] = (digitCount[num] || 0) + 1;
    }
    
    for (const num of sequence) {
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