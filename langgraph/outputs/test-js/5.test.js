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

describe('intersperse vs weaveNumbers equivalence tests', () => {
    const testCases = [
        [[], 0],
        [[1], 0],
        [[1, 2], 0],
        [[1, 2, 3], 0],
        [[1, 2, 3, 4], 'x']
    ];

    test.each(testCases)('Input: %o, delimiter: %o', (numbers, delimiter) => {
        expect(intersperse(numbers, delimiter)).toEqual(weaveNumbers(numbers, delimiter));
    });
});