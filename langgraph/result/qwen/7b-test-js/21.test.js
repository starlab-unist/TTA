// Source Code
function rescaleToUnit(numbers) {
    const minNumber = Math.min(...numbers);
    const maxNumber = Math.max(...numbers);
    return numbers.map(x => (x - minNumber) / (maxNumber - minNumber));
}

// Transformed Code (Semantically Equivalent)
function normalizeValues(values) {
    const minValue = Math.min(...values);
    const maxValue = Math.max(...values);
    const rangeValue = maxValue - minValue;

    const normalizedList = [];
    for (const number of values) {
        const normalizedNumber = (number - minValue) / rangeValue;
        normalizedList.push(normalizedNumber);
    }

    return normalizedList;
}

// Test Cases
describe('rescaleToUnit vs normalizeValues equivalence tests', () => {
    const testCases = [
        [1.0, 2.0, 3.0, 4.0, 5.0],
        [10.0, 20.0, 30.0, 40.0, 50.0],
        [5.0, 5.0, 5.0, 5.0],
        [-1.0, -2.0, -3.0, -4.0, -5.0],
        [0.0, 100.0],
        [3.14, 2.71, 1.618, 0.577],
        [100.0, 200.0, 300.0, 400.0, 500.0],
        [1.0, 1.0, 2.0, 2.0, 3.0, 3.0],
        [-5.0, 0.0, 5.0],
        [1000.0]
    ];

    test.each(testCases)('Input: %p', (inputNumbers) => {
        expect(rescaleToUnit(inputNumbers)).toEqual(normalizeValues(inputNumbers));
    });
});