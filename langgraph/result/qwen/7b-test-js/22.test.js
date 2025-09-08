// Source Code
function filterIntegers(values) {
    return values.filter(value => Number.isInteger(value));
}

// Transformed Code (Semantically Equivalent)
function extractIntegers(values) {
    let result = [];
    for (let item of values) {
        if (typeof item === 'number' && Number.isInteger(item)) {
            result.push(item);
        }
    }
    return result;
}

// Test Cases
describe('filterIntegers vs extractIntegers equivalence tests', () => {
    const testCases = [
        [1, 2, 3.5, 'a', 4],
        ['hello', 100, 200, 'world'],
        [1, 2, 3, 4, 5],
        ['x', 'y', 'z'],
        [null, true, false, 0, 1],
        [],
        [1.1, 2.2, 3.3],
        [1, '1', 2, '2', 3, '3'],
        [0, -1, -2, 3, 4],
        ['test', 123, 'example', 456]
    ];

    test.each(testCases)('Input: %p', (inputValues) => {
        expect(filterIntegers(inputValues)).toEqual(extractIntegers(inputValues));
    });
});