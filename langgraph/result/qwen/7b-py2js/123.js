function getOddCollatz(n) {
    let oddCollatz = [];
    if (n % 2 !== 0) {
        oddCollatz.push(n);
    }
    while (n > 1) {
        if (n % 2 === 0) {
            n /= 2;
        } else {
            n = n * 3 + 1;
        }
        if (n % 2 === 1) {
            oddCollatz.push(Math.floor(n));
        }
    }
    return oddCollatz.sort((a, b) => a - b);
}