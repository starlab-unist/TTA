function calculateModifiedSum(numbers) {
    let total = 0;
    for (let num of numbers) {
        if (num > 0 && num % 2 !== 0 && typeof num === 'number') {
            total += num ** 2;
        }
    }
    return total;
}