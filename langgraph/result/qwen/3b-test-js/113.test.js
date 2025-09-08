// Source Code
function oddCount(lst) {
    const result = [];
    for (const arr of lst) {
        const n = Array.from(arr).reduce((count, d) => count + (parseInt(d) % 2 === 1), 0);
        result.push(`the number of odd elements ${n}n the str${n}ng ${n} of the ${n}nput.`);
    }
    return result;
}

// Transformed Code (Semantically Equivalent)
function countOddsInSublists(inputList) {
    const result = [];
    for (const sublist of inputList) {
        const oddCount = Array.from(sublist).filter(digit => parseInt(digit) % 2 !== 0).length;
        result.push(`the number of odd elements ${oddCount}n the str${oddCount}ng ${oddCount} of the ${oddCount}nput.`);
    }
    return result;
}

// Test Cases
describe('oddCount vs countOddsInSublists equivalence tests', () => {
    const testCases = [
        [["12345"]],
        [["24680", "13579"]],
        [["1", "2", "3", "4", "5"]],
        [[]],
        [["0", "00", "000"]],
        [["111", "222", "333"]],
        [["135", "79", "2468"]],
        [["987654321"]],
        [["11", "22", "33"]],
        [["00000", "11111", "22222"]]
    ];

    test.each(testCases)('Input: %j', (inputList) => {
        expect(oddCount(inputList)).toBe(countOddsInSublists(inputList));
    });
});