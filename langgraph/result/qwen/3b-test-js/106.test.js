// Source Code
function f(n) {
    let ret = [];
    for (let i = 1; i <= n; i++) {
        if (i % 2 === 0) {
            let x = 1;
            for (let j = 1; j <= i; j++) {
                x *= j;
            }
            ret.push(x);
        } else {
            let x = 0;
            for (let j = 1; j <= i; j++) {
                x += j;
            }
            ret.push(x);
        }
    }
    return ret;
}

// Transformed Code (Semantically Equivalent)
function generateAlternatingSequence(limit) {
    let result = [];
    let index = 1;
    while (index <= limit) {
        if (index % 2 === 0) {
            let factorial = 1;
            let innerIndex = 1;
            while (innerIndex <= index) {
                factorial *= innerIndex;
                innerIndex++;
            }
            result.push(factorial);
        } else {
            let summation = 0;
            let innerIndex = 1;
            while (innerIndex <= index) {
                summation += innerIndex;
                innerIndex++;
            }
            result.push(summation);
        }
        index++;
    }
    return result;
}

// Test Cases
describe('f vs generateAlternatingSequence equivalence tests', () => {
    const testCases = [
        0,  // Edge case: no elements
        1,  // Only one element, odd
        2,  // Two elements, odd then even
        3,  // Three elements, odd, even, odd
        4,  // Four elements, odd, even, odd, even
        5,  // Five elements, odd, even, odd, even, odd
        10, // Ten elements
        20, // Twenty elements
        30, // Thirty elements
        50  // Fifty elements
    ];

    test.each(testCases)('Input: %i', (inputNumber) => {
        expect(f(inputNumber)).toBe(generateAlternatingSequence(inputNumber));
    });
});