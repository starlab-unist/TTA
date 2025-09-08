function uniqueDigits(x) {
    let oddDigitElements = [];
    for (let i of x) {
        if (i.toString().split('').every(c => parseInt(c) % 2 === 1)) {
            oddDigitElements.push(i);
        }
    }
    return oddDigitElements.sort((a, b) => a - b);
}