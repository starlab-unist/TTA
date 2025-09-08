function countPrimeHexDigits(hexString) {
    const primeHexDigits = new Set(['2', '3', '5', '7', 'B', 'D']);
    let count = 0;
    let index = 0;
    while (index < hexString.length) {
        if (primeHexDigits.has(hexString[index])) {
            count++;
        }
        index++;
    }
    return count;
}

// Method name: hexKey -> countPrimeHexDigits
// Parameter name: num -> hexString
// Variable name: primes -> primeHexDigits, total -> count
// Changed for loop to while loop
// Used a Set for primeHexDigits for potentially faster membership testing