// Source Code
function strangeSortList(lst) {
    let res = [];
    let switchFlag = true;
    while (lst.length > 0) {
        const element = switchFlag ? Math.min(...lst) : Math.max(...lst);
        res.push(element);
        lst.splice(lst.indexOf(element), 1);
        switchFlag = !switchFlag;
    }
    return res;
}

// Transformed Code (Semantically Equivalent)
function alternateSortSequence(sequence) {
    let result = [];
    let toggle = true;
    while (sequence.length > 0) {
        let selectedValue = toggle ? Math.min(...sequence) : Math.max(...sequence);
        result.push(selectedValue);
        sequence = sequence.filter(value => value !== selectedValue);
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
        expect(strangeSortList(inputList)).toEqual(alternateSortSequence([...inputList]));
    });
});