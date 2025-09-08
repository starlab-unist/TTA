function filterOddDigitNumbers(numbers) {
    const oddDigitNumbers = [];
    const iterator = numbers[Symbol.iterator]();
    
    while (true) {
        const { value: number, done } = iterator.next();
        if (done) break;
        
        if (String(number).split('').every(digit => parseInt(digit) % 2 !== 0)) {
            oddDigitNumbers.push(number);
        }
    }
    
    return oddDigitNumbers.sort((a, b) => a - b);
}