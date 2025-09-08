function extractMinEvenAndIndex(sequence) {
    if (!sequence.length) {
        return [];
    }

    const evenNumbers = sequence.filter(num => num % 2 === 0);
    if (!evenNumbers.length) {
        return [];
    }

    const smallestEven = Math.min(...evenNumbers);
    const positionOfSmallestEven = sequence.indexOf(smallestEven);

    return [smallestEven, positionOfSmallestEven];
}