function findMaxFrequencyIndex(numbers) {
    let maxValue = Math.max(...numbers);
    const frequencyArray = new Array(maxValue + 1).fill(0);

    for (let number of numbers) {
        frequencyArray[number]++;
    }

    let result = -1;
    let index = 1;
    while (index <= maxValue) {
        if (frequencyArray[index] >= index) {
            result = index;
        }
        index++;
    }

    return result;
}