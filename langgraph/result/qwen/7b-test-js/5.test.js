// Source Code
function intersperse(numbers, delimiter) {
    if (!numbers.length) {
        return [];
    }

    let result = [];

    for (let i = 0; i < numbers.length - 1; i++) {
        result.push(numbers[i]);
        result.push(delimiter);
    }

    result.push(numbers[numbers.length - 1]);

    return result;
}

// Transformed Code (Semantically Equivalent)
function weaveNumbers(numbers, delimiter) {
    if (!numbers.length) {
        return [];
    }

    let interleaved = [];
    let index = 0;

    while (index < numbers.length - 1) {
        interleaved.push(numbers[index]);
        interleaved.push(delimiter);
        index += 1;
    }

    interleaved.push(numbers[numbers.length - 1]);

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

    test.each(testCases)('Input: numbers=%s, delimiter=%s', (numbers, delimiter) => {
        expect(intersperse(numbers, delimiter)).toEqual(weaveNumbers(numbers, delimiter));
    });
});