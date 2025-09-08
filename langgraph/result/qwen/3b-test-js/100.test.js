// Source Code
function makeAPile(n) {
    return Array.from({ length: n }, (_, i) => n + 2 * i);
}

// Transformed Code (Semantically Equivalent)
function constructStack(size) {
    let pile = [];
    let index = 0;
    while (index < size) {
        pile.push(size + 2 * index);
        index += 1;
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

    test.each(testCases)('Input: %i', (inputSize) => {
        expect(makeAPile(inputSize)).toEqual(constructStack(inputSize));
    });
});