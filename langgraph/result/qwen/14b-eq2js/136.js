function findExtremeValues(numbers) {
    const negativeNumbers = numbers.filter(num => num < 0);
    const positiveNumbers = numbers.filter(num => num > 0);

    const maxNegative = negativeNumbers.length > 0 ? Math.max(...negativeNumbers) : null;
    const minPositive = positiveNumbers.length > 0 ? Math.min(...positiveNumbers) : null;

    return [maxNegative, minPositive];
}