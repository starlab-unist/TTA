// Source Code
function isSorted(arr) {
    let countDigit = {};
    arr.forEach(i => {
        if (countDigit[i]) {
            countDigit[i]++;
        } else {
            countDigit[i] = 1;
        }
    });
    if (Object.values(countDigit).some(count => count > 2)) {
        return false;
    }
    if (arr.every((value, index, array) => index === 0 || value >= array[index - 1])) {
        return true;
    } else {
        return false;
    }
}

// Transformed Code
function checkSortedSequence(sequence) {
    let digitCount = {};
    for (let num of sequence) {
        if (digitCount[num]) {
            digitCount[num]++;
        } else {
            digitCount[num] = 1;
        }
    }

    for (let num of sequence) {
        if (digitCount[num] > 2) {
            return false;
        }
    }

    for (let i = 1; i < sequence.length; i++) {
        if (sequence[i - 1] > sequence[i]) {
            return false;
        }
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