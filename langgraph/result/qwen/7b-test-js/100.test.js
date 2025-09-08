// Source Code
function makeAPile(n) {
    return Array.from({ length: n }, (_, i) => n + 2 * i);
}

// Transformed Code (Semantically Equivalent)
function constructStack(n) {
    let pile = [];
    let index = 0;
    while (index < n) {
        pile.push(n + 2 * index);
        index++;
    }
    return pile;
}

// Test Cases
describe('makeAPile vs constructStack equivalence tests', () => {
    const testCases = [
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    ];

    test.each(testCases)('Input: %d', (n) => {
        expect(makeAPile(n)).toEqual(constructStack(n));
    });
});