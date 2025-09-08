function findMaxFrequencyIndex(numbers) {
    const maxValue = Math.max(...numbers);
    const frequencyArray = new Array(maxValue + 1).fill(0);
    
    for (const number of numbers) {
        frequencyArray[number] += 1;
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