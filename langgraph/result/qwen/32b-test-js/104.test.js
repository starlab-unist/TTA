// Source Code
function uniqueDigits(arr) {
    const oddDigitElements = arr.filter(num => {
        return [...String(num)].every(digit => parseInt(digit) % 2 === 1);
    });
    return oddDigitElements.sort((a, b) => a - b);
}

// Transformed Code (Semantically Equivalent)
function filterOddDigitNumbers(numbers) {
    const oddDigitNumbers = [];
    const iterator = numbers[Symbol.iterator]();
    
    while (true) {
        const { value: number, done } = iterator.next();
        if (done) break;
        
        if (String(number).split('').every(digit => parseInt(digit) % 2 !== 0)) {
            oddDigitNumbers.push(number);
        }
    }
    
    return oddDigitNumbers.sort((a, b) => a - b);
}

// Test Cases
describe('uniqueDigits vs filterOddDigitNumbers equivalence tests', () => {
    const testCases = [
        [135, 246, 357, 579],
        [111, 333, 555, 777, 999],
        [222, 444, 666, 888],
        [13579, 2468, 12345],
        [1, 3, 5, 7, 9],
        [0, 2, 4, 6, 8],
        [135, 579, 791, 913],
        [],
        [113, 135, 357, 579],
        [123, 321, 213, 456]
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(uniqueDigits(inputArray)).toEqual(filterOddDigitNumbers(inputArray));
    });
});