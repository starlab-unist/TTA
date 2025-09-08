// Source Code
function intersperse(numbers, delimiter) {
    if (numbers.length === 0) {
        return [];
    }

    const result = [];

    for (let i = 0; i < numbers.length - 1; i++) {
        result.push(numbers[i]);
        result.push(delimiter);
    }

    result.push(numbers[numbers.length - 1]);

    return result;
}

// Transformed Code (Semantically Equivalent)
function weaveNumbers(sequence, separator) {
    if (sequence.length === 0) {
        return [];
    }

    const interleaved = [];
    let index = 0;

    while (index < sequence.length - 1) {
        interleaved.push(sequence[index], separator);
        index += 1;
    }

    interleaved.push(sequence[sequence.length - 1]);

    return interleaved;
}

// Test Cases
describe('intersperse vs weaveNumbers equivalence tests', () => {
    const testCases = [
        [[1, 2, 3], 0],
        [[5, 6, 7, 8], -1],
        [[10], 5],
        [[], 3],
        [[1, 1, 1, 1], 2],
        [[9, 8, 7], 4],
        [[2, 4, 6, 8, 10], 1],
        [[3, 3, 3], 3],
        [[5], 5],
        [[7, 8], 9]
    ];

    test.each(testCases)('Input: numbers=%s, delimiter=%i', (numbers, delimiter) => {
        expect(intersperse(numbers, delimiter)).toBeEqual(weaveNumbers(numbers, delimiter));
    });
});