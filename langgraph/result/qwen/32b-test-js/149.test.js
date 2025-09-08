// Source Code
function sortedListSum(lst) {
    lst.sort();
    const newLst = lst.filter(i => i.length % 2 === 0);
    return newLst.sort((a, b) => a.length - b.length);
}

// Transformed Code (Semantically Equivalent)
function evenLengthSortedElements(sequence) {
    sequence.sort();
    const filteredSequence = sequence.filter(element => element.length % 2 === 0);
    return filteredSequence.sort((a, b) => a.length - b.length);
}

// Test Cases
describe('sortedListSum vs evenLengthSortedElements equivalence tests', () => {
    const testCases = [
        ["apple", "banana", "cherry", "date"],
        ["one", "two", "three", "four", "five"],
        ["a", "bb", "ccc", "dddd", "eeeee", "ffffff"],
        ["", "a", "ab", "abc", "abcd", "abcde", "abcdef"],
        ["python", "java", "c++", "ruby", "swift", "go"],
        ["hello", "world", "foo", "bar", "baz"],
        ["short", "longer", "longest", "tiny"],
        ["even", "odd", "pair", "single"],
        ["aa", "bb", "cc", "dd"],
        ["abcd", "efgh", "ijkl", "mnop"]
    ];

    test.each(testCases)('Input: %j', (inputArray) => {
        expect(sortedListSum([...inputArray])).toEqual(evenLengthSortedElements([...inputArray]));
    });
});