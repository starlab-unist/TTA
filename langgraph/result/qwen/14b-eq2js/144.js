function checkFractionSimplification(fraction1, fraction2) {
    const [num1, denom1] = fraction1.split('/').map(Number);
    const [num2, denom2] = fraction2.split('/').map(Number);
    const resultNumerator = num1 * num2;
    const resultDenominator = denom1 * denom2;
    return resultNumerator % resultDenominator === 0;
}