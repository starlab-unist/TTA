function findMaxFrequencyIndex(lst) {
    const maxValue = Math.max(...lst);
    const frequencyArray = new Array(maxValue + 1).fill(0);

    for (let i = 0; i < lst.length; i++) {
        frequencyArray[lst[i]] += 1;
    }

    let result = -1;
    let index = 1;
    while (index < frequencyArray.length) {
        if (frequencyArray[index] >= index) {
            result = index;
        }
        index += 1;
    }

    return result;
}