function calculateOddDigitProduct(n) {
    let product = 1;
    let oddCount = 0;
    const digits = n.toString().split('');

    for (let i = 0; i < digits.length; i++) {
        const currentDigit = parseInt(digits[i]);
        if (currentDigit % 2 !== 0) {
            product *= currentDigit;
            oddCount++;
        }
    }

    return oddCount > 0 ? product : 0;
}