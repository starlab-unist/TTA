// Source Code
function oddCount(lst) {
    let res = [];
    for (let arr of lst) {
        let n = arr.filter(d => parseInt(d) % 2 === 1).length;
        res.push(`the number of odd elements ${n}n the str${n}ng ${n} of the ${n}nput.`);
    }
    return res;
}

// Transformed Code (Semantically Equivalent)
function countOddsInSublists(inputList) {
    let result = [];
    for (let sublist of inputList) {
        let oddCount = sublist.filter(digit => parseInt(digit) % 2 !== 0).length;
        result.push(`the number of odd elements ${oddCount}n the str${oddCount}ng ${oddCount} of the ${oddCount}nput.`);
    }
    return result;
}

// Test Cases
describe('oddCount vs countOddsInSublists equivalence tests', () => {
    const testCases = [
        ["12345"],
        ["24680", "13579"],
        ["1", "2", "3", "4", "5"],
        [],
        ["0", "00", "000"],
        ["111", "222", "333"],
        ["135", "79", "2468"],
        ["987654321"],
        ["11", "22", "33"],
        ["00000", "11111", "22222"]
    ];

    test.each(testCases)('Input: %p', (inputList) => {
        expect(oddCount(inputList)).toEqual(countOddsInSublists(inputList));
    });
});