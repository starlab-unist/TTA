function calculateOddSumAtEvenIndices(numbers) {
    let total = 0;
    let index = 0;
    while (index < numbers.length) {
        if (index % 2 === 0 && numbers[index] % 2 !== 0) {
            total += numbers[index];
        }
        index++;
    }
    return total;
}