function calculateSignedSum(numbers) {
    if (!numbers.length) {
        return null;
    }
    
    const negativeCount = numbers.reduce((count, num) => count + (num < 0 ? 1 : 0), 0);
    const containsZero = numbers.some(num => num === 0);
    
    const sign = containsZero ? 0 : Math.pow(-1, negativeCount);
    const totalSum = numbers.reduce((sum, num) => sum + Math.abs(num), 0);
    
    return sign * totalSum;
}