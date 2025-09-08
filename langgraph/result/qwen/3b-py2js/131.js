function digits(n) {
    let product = 1;
    let oddCount = 0;
    for (let digit of n.toString()) {
        const intDigit = parseInt(digit);
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