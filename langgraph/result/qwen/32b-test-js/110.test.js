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
function compareParity(listA, listB) {
    let oddCount = 0;
    let evenCount = 0;
    let index = 0;
    
    while (index < listA.length) {
        if (listA[index] % 2 !== 0) {
            oddCount += 1;
        }
        index += 1;
    }
    
    index = 0;
    while (index < listB.length) {
        if (listB[index] % 2 === 0) {
            evenCount += 1;
        }
        index += 1;
    }
    
    if (evenCount >= oddCount) {
        return "YES";
    }
    return "NO";
}

// Jest Test Cases
describe('exchange and compareParity functions', () => {
    const testCases = [
        { lst1: [1, 2, 3], lst2: [4, 5, 6], expected: "YES" }, // odd: 2, even: 2 -> YES
        { lst1: [1, 1, 1], lst2: [2, 4, 6], expected: "YES" }, // odd: 3, even: 3 -> YES
        { lst1: [1, 3, 5], lst2: [1, 3, 5], expected: "NO" },  // odd: 3, even: 0 -> NO
        { lst1: [2, 4, 6], lst2: [1, 3, 5], expected: "YES" }, // odd: 0, even: 3 -> YES
        { lst1: [], lst2: [], expected: "YES" },               // odd: 0, even: 0 -> YES
        { lst1: [1], lst2: [2], expected: "YES" },            // odd: 1, even: 1 -> YES
        { lst1: [1, 3, 5, 7], lst2: [2], expected: "NO" },     // odd: 4, even: 1 -> NO
        { lst1: [2, 4, 6, 8], lst2: [1, 3, 5], expected: "YES" },// odd: 3, even: 4 -> YES
        { lst1: [], lst2: [1, 3, 5], expected: "YES" }         // odd: 0, even: 0 -> YES (since even >= odd)
    ];

    testCases.forEach(({ lst1, lst2, expected }, index) => {
        test(`Test case ${index + 1}`, () => {
            expect(exchange(lst1, lst2)).toBe(expected);
            expect(compareParity(lst1, lst2)).toBe(expected);
        });
    });
});