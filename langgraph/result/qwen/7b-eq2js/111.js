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

// method name: histogram -> generateFrequencyMap
// parameter name: test -> inputString
// variable name: dict1 -> frequencyDict, list1 -> wordList, t -> maxCount
// replaced the initial check for non-empty string with a condition inside the loop
// used a separate variable `currentCount` to store the count of each word
// maintained the logic of finding the maximum occurrence and building the dictionary