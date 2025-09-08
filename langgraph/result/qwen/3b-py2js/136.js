function largestSmallestIntegers(lst) {
    const negativeNumbers = lst.filter(x => x < 0);
    const positiveNumbers = lst.filter(x => x > 0);

    const smallestNegative = negativeNumbers.length > 0 ? Math.min(...negativeNumbers) : null;
    const largestPositive = positiveNumbers.length > 0 ? Math.max(...positiveNumbers) : null;

    return [largestPositive, smallestNegative];
}