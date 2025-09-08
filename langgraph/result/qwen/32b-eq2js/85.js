function calculateEvenSumAtOddIndices(numbers) {
    let total = 0;
    let index = 1;
    while (index < numbers.length) {
        if (numbers[index] % 2 === 0) {
            total += numbers[index];
        }
        index += 2;
    }
    return total;
}