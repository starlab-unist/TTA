function countPrimeHexDigits(hexString) {
    const primeHexDigits = new Set(['2', '3', '5', '7', 'B', 'D']);
    let count = 0;
    let index = 0;
    while (index < hexString.length) {
        if (primeHexDigits.has(hexString[index])) {
            count += 1;
        }
        index += 1;
    }
    return count;
}