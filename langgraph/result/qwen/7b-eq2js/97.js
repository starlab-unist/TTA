function calculateUnitDigitProduct(a, b) {
    let unitDigitX = Math.abs(a % 10);
    let unitDigitY = Math.abs(b % 10);
    let product = unitDigitX * unitDigitY;
    return product;
}