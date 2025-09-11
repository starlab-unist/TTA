public int findMaxFrequencyIndex(int[] numbers) {
    int maxValue = Integer.MIN_VALUE;
    for (int number : numbers) {
        if (number > maxValue) {
            maxValue = number;
        }
    }

    int[] frequencyArray = new int[maxValue + 1];
    for (int number : numbers) {
        frequencyArray[number]++;
    }

    int result = -1;
    int index = 1;
    while (index < frequencyArray.length) {
        if (frequencyArray[index] >= index) {
            result = index;
        }
        index++;
    }

    return result;
}