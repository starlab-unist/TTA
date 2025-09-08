function calculateUnitDigitProduct(x, y) {
    const unitDigitX = Math.abs(x % 10);
    const unitDigitY = Math.abs(y % 10);
    const product = unitDigitX * unitDigitY;
    return product;
}