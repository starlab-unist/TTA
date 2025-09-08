// Source Code
function sortEven(arr) {
    let evens = arr.filter((_, index) => index % 2 === 0).sort((a, b) => a - b);
    let odds = arr.filter((_, index) => index % 2 !== 0);
    let ans = [];
    for (let i = 0; i < Math.min(evens.length, odds.length); i++) {
        ans.push(evens[i], odds[i]);
    }
    if (evens.length > odds.length) {
        ans.push(evens[evens.length - 1]);
    }
    return ans;
}

// Transformed Code (Semantically Equivalent)
function rearrangeEvenOdd(numbers) {
    let evenElements = numbers.filter((_, index) => index % 2 === 0);
    let oddElements = numbers.filter((_, index) => index % 2 !== 0);
    evenElements.sort((a, b) => a - b);
    let result = [];

    let index = 0;
    while (index < oddElements.length) {
        result.push(evenElements[index]);
        result.push(oddElements[index]);
        index++;
    }

    if (evenElements.length > oddElements.length) {
        result.push(evenElements[evenElements.length - 1]);
    }

    return result;
}

// Test Cases
describe('sortEven vs rearrangeEvenOdd equivalence tests', () => {
    const testCases = [
        ([2, 3, 4, 5, 6], [2, 3, 4, 5, 6]),
        ([10, 9, 8, 7, 6, 5], [6, 9, 8, 7, 10, 5]),
        ([1, 3, 5, 7, 2, 4, 6, 8], [1, 3, 2, 4, 5, 7, 6, 8]),
        ([1, 2], [1, 2]),
        ([5], [5]),
        ([], []),
        ([7, 1, 9, 3, 11, 5, 13], [7, 1, 9, 3, 11, 5, 13]),
        ([4, 2, 6, 8, 0, 10, 12, 14], [0, 2, 4, 8, 6, 10, 12, 14]),
        ([15, 14, 13, 12, 11, 10, 9], [9, 14, 11, 12, 13, 10, 15]),
        ([20, 19, 22, 21, 24, 23, 26, 25, 28], [20, 19, 22, 21, 24, 23, 26, 25, 28])
    ];

    testCases.forEach(([input, expected], index) => {
        it(`test_${index}`, () => {
            expect(sortEven(input)).toEqual(expected);
            expect(rearrangeEvenOdd(input)).toEqual(expected);
        });
    });
});