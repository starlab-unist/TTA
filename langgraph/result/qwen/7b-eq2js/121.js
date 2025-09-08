function calculateOddSumAtEvenIndices(lst) {
    let total = 0;
    let index = 0;
    while (index < lst.length) {
        if (index % 2 === 0 && lst[index] % 2 === 1) {
            total += lst[index];
        }
        index += 1;
    }
    return total;
}

// Example usage:
const result = calculateOddSumAtEvenIndices([3, 10, 5, 8, 7]);
console.log(result); // Output should be 10 (3 + 7)