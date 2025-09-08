function calculateModifiedSum(numbers) {
    let total = 0;
    let index = 0;
    while (index < numbers.length) {
        if (index % 3 === 0) {
            total += Math.pow(numbers[index], 2);
        } else if (index % 4 === 0) {
            total += Math.pow(numbers[index], 3);
        } else {
            total += numbers[index];
        }
        index += 1;
    }
    return total;
}