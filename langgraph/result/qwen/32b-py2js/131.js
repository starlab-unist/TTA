function digits(n) {
    let product = 1;
    let oddCount = 0;
    for (let digit of String(n)) {
        let intDigit = parseInt(digit, 10);
        if (intDigit % 2 === 1) {
            product *= intDigit;
            oddCount++;
        }
    }
    return oddCount === 0 ? 0 : product;
}