function calculateModifiedSum(lst) {
    let total = 0;
    let index = 0;
    while (index < lst.length) {
        if (index % 3 === 0) {
            total += Math.pow(lst[index], 2);
        } else if (index % 4 === 0) {
            total += Math.pow(lst[index], 3);
        } else {
            total += lst[index];
        }
        index++;
    }
    return total;
}

// Example usage:
console.log(calculateModifiedSum([1, 2, 3, 4, 5, 6, 7, 8, 9]));