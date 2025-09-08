// Source Code
function exchange(lst1, lst2) {
    let odd = 0;
    let even = 0;
    for (let i of lst1) {
        if (i % 2 === 1) {
            odd++;
        }
    }
    for (let i of lst2) {
        if (i % 2 === 0) {
            even++;
        }
    }
    if (even >= odd) {
        return "YES";
    }
    return "NO";
}

// Transformed Code (Semantically Equivalent)
function compare_parity(lst1, lst2) {
    let odd_count = 0;
    let even_count = 0;
    let index = 0;

    while (index < lst1.length) {
        if (lst1[index] % 2 !== 0) {
            odd_count++;
        }
        index++;
    }

    index = 0;
    while (index < lst2.length) {
        if (lst2[index] % 2 === 0) {
            even_count++;
        }
        index++;
    }

    return even_count >= odd_count ? "YES" : "NO";
}

// Test Cases
describe('exchange vs compare_parity equivalence tests', () => {
    const testCases = [
        { lst1: [1, 3, 5], lst2: [2, 4, 6] }, // odd: 3, even: 3 -> YES
        { lst1: [1, 1, 1], lst2: [2, 4, 6] }, // odd: 3, even: 3 -> YES
        { lst1: [1, 3, 5], lst2: [1, 3, 5] }, // odd: 3, even: 0 -> NO
        { lst1: [2, 4, 6], lst2: [1, 3, 5] }, // odd: 0, even: 3 -> YES
        { lst1: [], lst2: [] },              // odd: 0, even: 0 -> YES
        { lst1: [1], lst2: [2] },            // odd: 1, even: 1 -> YES
        { lst1: [1, 3, 5, 7], lst2: [2] },   // odd: 4, even: 1 -> NO
        { lst1: [2, 4, 6, 8], lst2: [1, 3, 5] }, // odd: 3, even: 4 -> YES
        { lst1: [], lst2: [1, 3, 5] }         // odd: 0, even: 3 -> YES (since even >= odd)
    ];

    testCases.forEach(({ lst1, lst2 }, index) => {
        it(`Test case ${index}`, () => {
            expect(exchange(lst1, lst2)).toBe(compare_parity(lst1, lst2));
        });
    });
});