function produceEvenNumbers(x, y) {
    const start = Math.max(2, Math.min(x, y));
    const end = Math.min(8, Math.max(x, y));

    const evenNumbers = [];
    let current = start;
    while (current <= end) {
        if (current % 2 === 0) {
            evenNumbers.push(current);
        }
        current += 1;
    }

    return evenNumbers;
}