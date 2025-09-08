function checkFractionSimplification(fraction1, fraction2) {
    const [num1, denom1] = fraction1.split('/').map(Number);
    const [num2, denom2] = fraction2.split('/').map(Number);
    const numerator = num1 * num2;
    const denominator = denom1 * denom2;
    return numerator % denominator === 0;
}