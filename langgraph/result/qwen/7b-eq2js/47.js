function calculateMedian(numbers) {
    const sortedNumbers = [...numbers].sort((a, b) => a - b);
    const midIndex = Math.floor(sortedNumbers.length / 2);

    if (sortedNumbers.length % 2 === 1) {
        return sortedNumbers[midIndex];
    } else {
        return (sortedNumbers[midIndex - 1] + sortedNumbers[midIndex]) / 2.0;
    }
}