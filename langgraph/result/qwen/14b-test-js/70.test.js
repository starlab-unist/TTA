// Source Code
function strangeSortList(lst) {
    const res = [];
    let switchFlag = true;
    while (lst.length > 0) {
        res.push(switchFlag ? Math.min(...lst) : Math.max(...lst));
        lst.splice(lst.indexOf(res[res.length - 1]), 1);
        switchFlag = !switchFlag;
    }
    return res;
}

// Transformed Code
function alternateSortSequence(sequence) {
    const result = [];
    let toggle = true;
    while (sequence.length > 0) {
        const selectedValue = toggle ? Math.min(...sequence) : Math.max(...sequence);
        result.push(selectedValue);
        sequence.splice(sequence.indexOf(selectedValue), 1);
        toggle = !toggle;
    }
    return result;
}

// Test Cases
describe('strangeSortList vs alternateSortSequence equivalence tests', () => {
    const testCases = [
        [3, 1, 2],
        [9, 7, 5, 3, 1],
        [10, 20, 30, 40, 50],
        [5, 5, 5, 5],
        [1],
        [],
        [8, 6, 7, 5, 3, 0, 9],
        [2, 2, 2, 1, 1, 1, 3, 3, 3],
        [-1, -2, -3, -4, -5],
        [100, 200, 150, 50, 250]
    ];

    test.each(testCases)('Input: %p', (inputList) => {
        expect(strangeSortList([...inputList])).toEqual(alternateSortSequence([...inputList]))
    });
});