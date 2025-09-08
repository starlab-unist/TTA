// Source Code
function fizzBuzz(n) {
    const ns = [];
    for (let i = 0; i < n; i++) {
        if (i % 11 === 0 || i % 13 === 0) {
            ns.push(i);
        }
    }
    const s = ns.join('');
    let ans = 0;
    for (const c of s) {
        if (c === '7') {
            ans++;
        }
    }
    return ans;
}

// Transformed Code (Semantically Equivalent)
function countSevensInSpecialNumbers(limit) {
    const specialNumbers = [];
    let index = 0;
    while (index < limit) {
        if (index % 11 === 0 || index % 13 === 0) {
            specialNumbers.push(index);
        }
        index += 1;
    }

    const concatenatedString = specialNumbers.join('');
    let sevenCount = 0;
    let position = 0;
    while (position < concatenatedString.length) {
        if (concatenatedString[position] === '7') {
            sevenCount += 1;
        }
        position += 1;
    }

    return sevenCount;
}

// Test Cases
describe('fizzBuzz vs countSevensInSpecialNumbers equivalence tests', () => {
    const testCases = [
        0,
        1,
        25,
        50,
        75,
        100,
        125,
        150,
        200,
        300
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(fizzBuzz(inputNumber)).toBe(countSevensInSpecialNumbers(inputNumber));
    });
});