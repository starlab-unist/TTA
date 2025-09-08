function calculateOddDigitProduct(number) {
    let result = 1;
    let oddDigitsFound = 0;
    const digitIterator = String(number)[Symbol.iterator]();

    while (true) {
        const nextDigit = digitIterator.next();
        if (nextDigit.done) {
            break;
        }
        const currentDigit = parseInt(nextDigit.value, 10);
        if (currentDigit % 2 !== 0) {
            result *= currentDigit;
            oddDigitsFound += 1;
        }
    }

    return oddDigitsFound > 0 ? result : 0;
}