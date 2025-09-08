// Source Code
function sortEven(arr) {
    const evens = arr.filter((_, index) => index % 2 === 0);
    const odds = arr.filter((_, index) => index % 2 !== 0);
    evens.sort((a, b) => a - b);
    const ans = [];
    for (let i = 0; i < odds.length; i++) {
        ans.push(evens[i], odds[i]);
    }
    if (evens.length > odds.length) {
        ans.push(evens[evens.length - 1]);
    }
    return ans;
}

// Transformed Code (Semantically Equivalent)
function rearrangeEvenOdd(numbers) {
    const evenElements = numbers.filter((_, index) => index % 2 === 0);
    const oddElements = numbers.filter((_, index) => index % 2 !== 0);
    evenElements.sort((a, b) => a - b);
    const result = [];

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
        [2, 3, 4, 5, 6],
        [10, 9, 8, 7, 6, 5],
        [1, 3, 5, 7, 2, 4, 6, 8],
        [1, 2],
        [5],
        [],
        [7, 1, 9, 3, 11, 5, 13],
        [4, 2, 6, 8, 0, 10, 12, 14],
        [15, 14, 13, 12, 11, 10, 9],
        [20, 19, 22, 21, 24, 23, 26, 25, 28]
    ];

    const expectedResults = [
        [2, 3, 4, 5, 6],
        [6, 9, 8, 7, 10, 5],
        [1, 3, 2, 4, 5, 7, 6, 8],
        [1, 2],
        [5],
        [],
        [7, 1, 9, 3, 11, 5, 13],
        [0, 2, 4, 8, 6, 10, 12, 14],
        [9, 14, 11, 12, 13, 10, 15],
        [20, 19, 22, 21, 24, 23, 26, 25, 28]
    ];

    testCases.forEach((testCase, index) => {
        it(`Test case ${index}`, () => {
            expect(sortEven(testCase)).toEqual(expectedResults[index]);
            expect(rearrangeEvenOdd(testCase)).toEqual(expectedResults[index]);
        });
    });
});