// Source Code
function common(l1, l2) {
    let ret = new Set();
    for (let e1 of l1) {
        for (let e2 of l2) {
            if (e1 === e2) {
                ret.add(e1);
            }
        }
    }
    return [...ret].sort();
}

// Transformed Code (Semantically Equivalent)
function findSharedElements(listA, listB) {
    const sharedItems = new Set();
    const iteratorA = listA.values();

    while (true) {
        const elementA = iteratorA.next().value;
        if (elementA === undefined) break;

        for (const elementB of listB) {
            if (elementA === elementB) {
                sharedItems.add(elementA);
            }
        }
    }

    return Array.from(sharedItems).sort();
}

// Test Cases
describe('common vs findSharedElements equivalence tests', () => {
    const testCases = [
        [[1, 2, 3], [2, 3, 4]],
        [['a', 'b', 'c'], ['b', 'c', 'd']],
        [[10, 20, 30], [40, 50, 60]],
        [[], []],
        [[1, 1, 2, 2], [2, 2, 3, 3]],
        [['apple', 'banana'], ['banana', 'orange']],
        [[true, false], [false, true]],
        [['x', 'y', 'z'], ['a', 'b', 'c']],
        [[1, 2, 3, 4, 5], [3, 4, 5, 6, 7]],
        [[null, null, null], [null]]
    ];

    test.each(testCases)('Input: %j and %j', (listA, listB) => {
        expect(common(listA, listB)).toEqual(findSharedElements(listA, listB));
    });
});