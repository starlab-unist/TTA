function checkForZeroSumPairs(numbers) {
    let index = 0;
    while (index < numbers.length) {
        const currentNumber = numbers[index];
        let nextIndex = index + 1;
        while (nextIndex < numbers.length) {
            if (currentNumber + numbers[nextIndex] === 0) {
                return true;
            }
            nextIndex++;
        }
        index++;
    }
    return false;
}