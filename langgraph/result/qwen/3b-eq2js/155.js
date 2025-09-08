function tallyEvenOddDigits(number) {
    let evenTally = 0;
    let oddTally = 0;
    let index = 0;
    const numStr = Math.abs(number).toString();
    
    while (index < numStr.length) {
        const digit = parseInt(numStr[index], 10);
        if (digit % 2 === 0) {
            evenTally++;
        } else {
            oddTally++;
        }
        index++;
    }
    
    return [evenTally, oddTally];
}

// method name: even_odd_count -> tallyEvenOddDigits
// parameter name: num -> number
// variable names: even_count -> evenTally, odd_count -> oddTally
// replaced for loop with while loop and index increment
// kept the logic and return type the same