function findSecondMinimum(numbers) {
    const uniqueNumbers = [...new Set(numbers)].sort((a, b) => a - b);

    if (uniqueNumbers.length < 2) {
        return null;
    }

    return uniqueNumbers[1];
}