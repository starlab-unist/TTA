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
function compareParity(listA, listB) {
    let oddCount = 0;
    let evenCount = 0;
    let index = 0;

    while (index < listA.length) {
        if (listA[index] % 2 !== 0) {
            oddCount++;
        }
        index++;
    }

    index = 0;
    while (index < listB.length) {
        if (listB[index] % 2 === 0) {
            evenCount++;
        }
        index++;
    }

    return evenCount >= oddCount ? "YES" : "NO";
}

// Test Cases
describe('exchange vs compareParity equivalence tests', () => {
    const testCases = [
        { lst1: [1, 3, 5], lst2: [2, 4, 6], expected: "YES" },
        { lst1: [1, 1, 1], lst2: [2, 4, 6], expected: "YES" },
        { lst1: [1, 3, 5], lst2: [1, 3, 5], expected: "NO" },
        { lst1: [2, 4, 6], lst2: [1, 3, 5], expected: "YES" },
        { lst1: [], lst2: [], expected: "YES" },
        { lst1: [1], lst2: [2], expected: "YES" },
        { lst1: [1, 3, 5, 7], lst2: [2], expected: "NO" },
        { lst1: [2, 4, 6, 8], lst2: [1, 3, 5], expected: "YES" },
        { lst1: [], lst2: [1, 3, 5], expected: "YES" }
    ];

    testCases.forEach(({ lst1, lst2, expected }, index) => {
        it(`Test case ${index}`, () => {
            expect(exchange(lst1, lst2)).toBe(compareParity(lst1, lst2));
            expect(compareParity(lst1, lst2)).toBe(expected);
        });
    });
});