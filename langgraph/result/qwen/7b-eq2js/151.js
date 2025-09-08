function calculateModifiedSum(lst) {
    let total = 0;
    for (let num of lst) {
        if (num > 0 && num % 2 !== 0 && Number.isInteger(num)) {
            total += Math.pow(num, 2);
        }
    }
    return total;
}