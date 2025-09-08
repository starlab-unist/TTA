function extractDecimalPart(number) {
    const decimalPart = number - Math.floor(number);
    return decimalPart;
}