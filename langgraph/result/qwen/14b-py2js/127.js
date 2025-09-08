function intersection(interval1, interval2) {
    function isPrime(num) {
        if (num === 1 || num === 0) {
            return false;
        }
        if (num === 2) {
            return true;
        }
        for (let i = 2; i < num; i++) {
            if (num % i === 0) {
                return false;
            }
        }
        return true;
    }

    const l = Math.max(interval1[0], interval2[0]);
    const r = Math.min(interval1[1], interval2[1]);
    const length = r - l;
    if (length > 0 && isPrime(length)) {
        return "YES";
    }
    return "NO";
}