function checkIntervalForPrimeLength(range1, range2) {
    function primeCheck(number) {
        if (number === 0 || number === 1) return false;
        if (number === 2) return true;
        for (let divisor = 2; divisor < number; divisor++) {
            if (number % divisor === 0) return false;
        }
        return true;
    }

    const [start, end] = range1.length > range2.length ? range1 : range2;
    const span = end - start;
    if (span > 0 && primeCheck(span)) {
        return "YES";
    }
    return "NO";
}