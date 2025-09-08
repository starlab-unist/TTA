function uniqueDigits(arr) {
    const oddDigitElements = arr.filter(num => {
        return [...String(num)].every(digit => parseInt(digit) % 2 === 1);
    });
    return oddDigitElements.sort((a, b) => a - b);
}