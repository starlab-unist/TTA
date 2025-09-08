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

function intersection(interval1, interval2) {
    let l = Math.max(interval1[0], interval2[0]);
    let r = Math.min(interval1[1], interval2[1]);
    let length = r - l;
    if (length > 0 && isPrime(length)) {
        return "YES";
    }
    return "NO";
}