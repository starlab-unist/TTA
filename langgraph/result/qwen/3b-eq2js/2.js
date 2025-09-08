function extractDecimalPart(value) {
    const decimalPart = value - Math.floor(value);
    return decimalPart;
}