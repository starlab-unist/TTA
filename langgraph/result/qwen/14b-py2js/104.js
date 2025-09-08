function uniqueDigits(x) {
    const oddDigitElements = [];
    for (const i of x) {
        if ([...String(i)].every(c => parseInt(c) % 2 === 1)) {
            oddDigitElements.push(i);
        }
    }
    return oddDigitElements.sort((a, b) => a - b);
}