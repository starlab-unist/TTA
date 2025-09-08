// Source Code
function exchange(lst1, lst2) {
    let odd = 0;
    let even = 0;
    for (let i of lst1) {
        if (i % 2 === 1) {
            odd += 1;
        }
    }
    for (let i of lst2) {
        if (i % 2 === 0) {
            even += 1;
        }
    }
    if (even >= odd) {
        return "YES";
    }
    return "NO";
}

// Transformed Code (Semantically Equivalent)
function compare_parity(list_a, list_b) {
    let odd_count = 0;
    let even_count = 0;
    let index = 0;

    while (index < list_a.length) {
        if (list_a[index] % 2 !== 0) {
            odd_count += 1;
        }
        index += 1;
    }

    index = 0;
    while (index < list_b.length) {
        if (list_b[index] % 2 === 0) {
            even_count += 1;
        }
        index += 1;
    }

    return even_count >= odd_count ? "YES" : "NO";
}

// Jest Test Cases
describe('exchange and compare_parity functions', () => {
    const testCases = [
        { lst1: [1, 2, 3], lst2: [4, 5, 6], expected: 'YES' }, // odd: 2, even: 2 -> YES
        { lst1: [1, 1, 1], lst2: [2, 4, 6], expected: 'YES' }, // odd: 3, even: 3 -> YES
        { lst1: [1, 3, 5], lst2: [1, 3, 5], expected: 'NO' },  // odd: 3, even: 0 -> NO
        { lst1: [2, 4, 6], lst2: [1, 3, 5], expected: 'YES' }, // odd: 0, even: 3 -> YES
        { lst1: [],        lst2: [],        expected: 'YES' },  // odd: 0, even: 0 -> YES
        { lst1: [1],       lst2: [2],       expected: 'YES' },  // odd: 1, even: 1 -> YES
        { lst1: [1, 3, 5, 7], lst2: [2],    expected: 'NO' },  // odd: 4, even: 1 -> NO
        { lst1: [2, 4, 6, 8], lst2: [1, 3, 5], expected: 'YES' }, // odd: 3, even: 4 -> YES
        { lst1: [],        lst2: [1, 3, 5], expected: 'YES' }   // odd: 0, even: 0 -> YES (since even >= odd)
    ];

    testCases.forEach(({ lst1, lst2, expected }, index) => {
        it(`should return the same result for test case ${index}`, () => {
            expect(exchange(lst1, lst2)).toBe(expected);
            expect(compare_parity(lst1, lst2)).toBe(expected);
        });
    });
});