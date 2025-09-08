function digits(n) {
    let product = 1;
    let oddCount = 0;
    const digits = n.toString().split('');

    for (let i = 0; i < digits.length; i++) {
        const intDigit = parseInt(digits[i], 10);
        if (intDigit % 2 === 1) {
            product *= intDigit;
            oddCount++;
        }
    }

    if (oddCount === 0) {
        return 0;
    } else {
        return product;
    }
}