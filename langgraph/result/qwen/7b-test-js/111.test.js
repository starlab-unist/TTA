// Source Code
function histogram(test) {
    let dict1 = {};
    let list1 = test.split(" ");
    let t = 0;

    for (let i of list1) {
        if ((list1.filter(x => x === i).length > t) && i !== '') {
            t = list1.filter(x => x === i).length;
        }
    }

    if (t > 0) {
        for (let i of list1) {
            if (list1.filter(x => x === i).length === t) {
                dict1[i] = t;
            }
        }
    }

    return dict1;
}

// Transformed Code (Semantically Equivalent)
function generateFrequencyMap(inputString) {
    let frequencyDict = {};
    let wordList = inputString.split(' ');
    let maxCount = 0;

    for (let i = 0; i < wordList.length; i++) {
        let currentCount = wordList.filter(word => word === wordList[i]).length;
        if (currentCount > maxCount && wordList[i] !== '') {
            maxCount = currentCount;
        }
    }

    if (maxCount > 0) {
        for (let i = 0; i < wordList.length; i++) {
            if (wordList.filter(word => word === wordList[i]).length === maxCount) {
                frequencyDict[wordList[i]] = maxCount;
            }
        }
    }

    return frequencyDict;
}

// Test Cases
describe('histogram vs generateFrequencyMap equivalence tests', () => {
    const testCases = [
        "apple apple banana",
        "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty",
        "a a a b b c",
        "hello world hello",
        "test test test test",
        "unique words only here",
        "repeated repeated repeated repeated",
        "no no no no no no no",
        "singleword",
        ""
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(histogram(inputText)).toEqual(generateFrequencyMap(inputText));
    });
});