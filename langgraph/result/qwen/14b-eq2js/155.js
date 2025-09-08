function tallyEvenOddDigits(number) {
    let evenTally = 0;
    let oddTally = 0;
    let index = 0;
    const numStr = Math.abs(number).toString();
    
    while (index < numStr.length) {
        const digit = parseInt(numStr[index], 10);
        if (digit % 2 === 0) {
            evenTally += 1;
        } else {
            oddTally += 1;
        }
        index += 1;
    }
    
    return [evenTally, oddTally];
}