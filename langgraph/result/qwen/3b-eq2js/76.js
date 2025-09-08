function checkPowerRelation(base, exponent) {
    if (exponent === 1) {
        return base === 1;
    }

    let currentValue = 1;
    while (currentValue < base) {
        currentValue *= exponent;
    }

    return currentValue === base;
}