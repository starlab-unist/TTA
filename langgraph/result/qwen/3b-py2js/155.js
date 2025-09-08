function evenOddCount(num) {
    let evenCount = 0;
    let oddCount = 0;
    const absNumStr = Math.abs(num).toString();
    
    for (let char of absNumStr) {
        const digit = parseInt(char);
        if (digit % 2 === 0) {
            evenCount++;
        } else {
            oddCount++;
        }
    }
    
    return [evenCount, oddCount];
}

console.log(evenOddCount(12345)); // Example usage