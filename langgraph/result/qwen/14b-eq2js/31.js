function checkPrime(number) {
    if (number < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < number - 1) {
        if (number % divisor === 0) {
            return false;
        }
        divisor += 1;
    }
    return true;
}