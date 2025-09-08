function filterOddDigitNumbers(numbers) {
    const oddDigitNumbers = [];
    const iterator = numbers[Symbol.iterator]();
    
    while (true) {
        const result = iterator.next();
        if (result.done) {
            break;
        }
        
        const number = result.value;
        if (Array.from(String(number)).every(digit => parseInt(digit) % 2 !== 0)) {
            oddDigitNumbers.push(number);
        }
    }
    
    return oddDigitNumbers.sort((a, b) => a - b);
}