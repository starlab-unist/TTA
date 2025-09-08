function isPrime(n) {
    if (n < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < n - 1) {
        if (n % divisor === 0) {
            return false;
        }
        divisor++;
    }
    return true;
}