// Source Code
function byLength(arr) {
    const dic = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
    };
    const sortedArr = arr.sort((a, b) => b - a);
    const newArr = [];
    for (const varItem of sortedArr) {
        if (dic.hasOwnProperty(varItem)) {
            newArr.push(dic[varItem]);
        }
    }
    return newArr;
}

// Transformed Code (Semantically Equivalent)
function arrangeByNumberName(numbers) {
    const numberNames = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
    };
    const descendingNumbers = numbers.sort((a, b) => b - a);
    const namedNumbers = [];
    let index = 0;
    while (index < descendingNumbers.length) {
        const num = descendingNumbers[index];
        if (numberNames.hasOwnProperty(num)) {
            namedNumbers.push(numberNames[num]);
        }
        index += 1;
    }
    return namedNumbers;
}

// Test Cases
describe('byLength vs arrangeByNumberName equivalence tests', () => {
    const testCases = [
        [3, 2, 1],
        [9, 8, 7, 6, 5],
        [4, 4, 4, 4],
        [10, 11, 12],  // should return empty as none are in the dictionary
        [],
        [1, 2, 3, 4, 5, 6, 7, 8, 9],
        [9, 3, 5, 7, 1],
        [2, 2, 2, 3, 3, 1],
        [5],  // single element
        [0, -1, 10]   // should return empty as none are in the dictionary
    ];

    test.each(testCases)('Input: %j', (inputArray) => {
        expect(byLength(inputArray.slice())).toBeEqual(arrangeByNumberName(inputArray.slice()));
    });
});