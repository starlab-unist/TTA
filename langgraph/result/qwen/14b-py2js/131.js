function digits(n) {
    let product = 1;
    let oddCount = 0;
    const digitsStr = n.toString();
    
    for (let i = 0; i < digitsStr.length; i++) {
        const intDigit = parseInt(digitsStr[i], 10);
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