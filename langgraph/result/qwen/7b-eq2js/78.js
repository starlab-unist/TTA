function countPrimeHexDigits(num) {
    const primeHexDigits = new Set(['2', '3', '5', '7', 'B', 'D']);
    let total = 0;
    let index = 0;
    while (index < num.length) {
        if (primeHexDigits.has(num[index])) {
            total += 1;
        }
        index += 1;
    }
    return total;
}