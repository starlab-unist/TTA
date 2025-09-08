function countSpecialNumbers(numbers) {
    let total = 0;
    const iterator = numbers[Symbol.iterator]();
    
    while (true) {
        const result = iterator.next();
        if (result.done) break;
        
        const currentNumber = result.value;
        if (currentNumber > 10) {
            const oddDigitsSet = new Set([1, 3, 5, 7, 9]);
            const numStr = currentNumber.toString();
            if (oddDigitsSet.has(parseInt(numStr[0])) && oddDigitsSet.has(parseInt(numStr[numStr.length - 1]))) {
                total += 1;
            }
        }
    }
    
    return total;
}