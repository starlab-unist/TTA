function calculateTotalUpTo(number) {
    let totalSum = 0;
    let current = 0;

    while (current <= number) {
        totalSum += current;
        current += 1;
    }

    return totalSum;
}