function calculateOddSumAtEvenIndices(numbers) {
    let total = 0;
    let index = 0;
    while (index < numbers.length) {
        if (index % 2 === 0 && numbers[index] % 2 === 1) {
            total += numbers[index];
        }
        index += 1;
    }
    return total;
}

// method name: solution -> calculateOddSumAtEvenIndices
// parameter name: lst -> numbers
// replaced list comprehension with while loop and if condition
// used a manual sum calculation instead of sum() on a list comprehension