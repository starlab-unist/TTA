function determineValueBasedOnDivisibility(number, valueIfNotPrime, valueIfPrime) {
    if (number === 1) {
        return valueIfPrime;
    }

    let divisor = 2;
    while (divisor < number) {
        if (number % divisor === 0) {
            return valueIfPrime;
        }
        divisor += 1;
    }
    return valueIfNotPrime;
}