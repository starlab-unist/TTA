function findGreatestDivisor(number) {
    let divisor = number - 1;
    while (divisor > 0) {
        if (number % divisor === 0) {
            return divisor;
        }
        divisor--;
    }
}

console.log(findGreatestDivisor(15)); // Example usage