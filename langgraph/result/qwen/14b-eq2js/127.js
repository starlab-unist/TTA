function checkIntervalForPrimeLength(range1, range2) {
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

    const start = Math.max(range1[0], range2[0]);
    const end = Math.min(range1[1], range2[1]);
    const span = end - start;
    if (span > 0 && primeCheck(span)) {
        return "YES";
    }
    return "NO";
}