function truncateNumber(number) {
    return number % 1.0;
}

function extractDecimalPart(value) {
    const decimalPart = value - Math.floor(value);
    return decimalPart;
}

describe('truncateNumber vs extractDecimalPart equivalence tests', () => {
    const testCases = [
        [0],
        [0.5],
        [1.0],
        [2.718],
        [3.14159],
        [10.0],
        [0.001],
        [123456.789],
        [0.999],
        [1.0001]
    ];

    test.each(testCases)('Input: %p', (inputNumber) => {
        expect(truncateNumber(inputNumber)).toBe(extractDecimalPart(inputNumber));
    });
});