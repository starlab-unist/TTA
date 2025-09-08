function checkIntervalForPrimeLength(interval1, interval2) {
    function primeCheck(number) {
        if (number === 0 || number === 1) {
            return false;
        }
        if (number === 2) {
            return true;
        }
        for (let divisor = 2; divisor < number; divisor++) {
            if (number % divisor === 0) {
                return false;
            }
        }
        return true;
    }

    const [l, r] = [Math.max(...interval1), Math.min(...interval2)];
    const length = r - l;
    if (length > 0 && primeCheck(length)) {
        return "YES";
    }
    return "NO";
}