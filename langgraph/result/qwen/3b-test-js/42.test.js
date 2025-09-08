// Source Code
function incrList(l) {
    return l.map(e => e + 1);
}

// Transformed Code (Semantically Equivalent)
function incrementElements(inputList) {
    let result = [];
    let index = 0;
    while (index < inputList.length) {
        result.push(inputList[index] + 1);
        index++;
    }
    return result;
}

// Test Cases
describe('incrList vs incrementElements equivalence tests', () => {
    const testCases = [
        [1, 2, 3, 4, 5],
        [-1, -2, -3, -4, -5],
        [0, 0, 0, 0],
        [],
        [100, 200, 300],
        [-100, 0, 100],
        [1],
        [-1],
        [0],
        [9, 8, 7, 6, 5]
    ];

    test.each(testCases)('Input: %p', (inputList) => {
        expect(incrList(inputList)).toEqual(incrementElements(inputList));
    });
});