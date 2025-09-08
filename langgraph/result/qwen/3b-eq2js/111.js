function generateFrequencyMap(inputString) {
    const frequencyDict = {};
    const wordList = inputString.split(' ');
    let maxCount = 0;

    for (let word of wordList) {
        const currentCount = wordList.filter(w => w === word).length;
        if (currentCount > maxCount && word !== '') {
            maxCount = currentCount;
        }
    }

    if (maxCount > 0) {
        for (let word of wordList) {
            if (wordList.filter(w => w === word).length === maxCount) {
                frequencyDict[word] = maxCount;
            }
        }
    }

    return frequencyDict;
}