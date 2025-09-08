function findPrimesBelow(limit) {
    const primeNumbers = [];
    let candidate = 2;
    while (candidate < limit) {
        let divisor = 2;
        let isDivisible = false;
        while (divisor < candidate) {
            if (candidate % divisor === 0) {
                isDivisible = true;
                break;
            }
            divisor += 1;
        }
        if (!isDivisible) {
            primeNumbers.push(candidate);
        }
        candidate += 1;
    }
    return primeNumbers;
}