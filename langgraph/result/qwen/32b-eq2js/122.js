function calculateSumOfSmallNumbers(numbers, count) {
    let total = 0;
    let index = 0;
    
    while (index < count && index < numbers.length) {
        if (numbers[index].toString().length <= 2) {
            total += numbers[index];
        }
        index += 1;
    }
    
    return total;
}