function findGreatestDivisor(number) {
    let divisor = number - 1;
    while (divisor > 0) {
        if (number % divisor === 0) {
            return divisor;
        }
        divisor--;
    }
}

// Example usage:
console.log(findGreatestDivisor(15)); // Output should be 5