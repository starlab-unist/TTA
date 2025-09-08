function calculateOddDigitProduct(number) {
    let result = 1;
    let oddDigitsFound = 0;
    const digitIterator = number.toString().split('');

    while (digitIterator.length > 0) {
        const currentDigit = parseInt(digitIterator.shift(), 10);
        if (currentDigit % 2 !== 0) {
            result *= currentDigit;
            oddDigitsFound++;
        }
    }

    return oddDigitsFound > 0 ? result : 0;
}