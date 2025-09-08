// Source Code
function histogram(test) {
    const dict1 = {};
    const list1 = test.split(" ");
    let t = 0;

    for (const i of list1) {
        if (list1.filter(x => x === i).length > t && i !== '') {
            t = list1.filter(x => x === i).length;
        }
    }
    if (t > 0) {
        for (const i of list1) {
            if (list1.filter(x => x === i).length === t) {
                dict1[i] = t;
            }
        }
    }
    return dict1;
}

// Transformed Code (Semantically Equivalent)
function generateFrequencyMap(inputString) {
    const frequencyDict = {};
    const wordList = inputString.split(" ");
    let maxCount = 0;

    for (const word of wordList) {
        const currentCount = wordList.filter(w => w === word).length;
        if (currentCount > maxCount && word !== '') {
            maxCount = currentCount;
        }
    }

    if (maxCount > 0) {
        for (const word of wordList) {
            if (wordList.filter(w => w === word).length === maxCount) {
                frequencyDict[word] = maxCount;
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