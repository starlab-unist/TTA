function findExtremeValues(numbers) {
    const negativeNumbers = numbers.filter(num => num < 0);
    const positiveNumbers = numbers.filter(num => num > 0);

    const maxNegative = negativeNumbers.length ? Math.max(...negativeNumbers) : null;
    const minPositive = positiveNumbers.length ? Math.min(...positiveNumbers) : null;

    return [maxNegative, minPositive];
}