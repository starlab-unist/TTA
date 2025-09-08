function produceEvenNumbers(a, b) {
    let start = Math.max(2, Math.min(a, b));
    let end = Math.min(8, Math.max(a, b));

    let evenNumbers = [];
    let current = start;
    while (current <= end) {
        if (current % 2 === 0) {
            evenNumbers.push(current);
        }
        current += 1;
    }

    return evenNumbers;
}