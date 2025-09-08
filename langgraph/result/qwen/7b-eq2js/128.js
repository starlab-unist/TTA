function calculateSignedSum(arr) {
    if (!arr.length) {
        return null;
    }
    
    const negativeCount = arr.filter(num => num < 0).length;
    const containsZero = arr.some(num => num === 0);
    
    let sign = containsZero ? 0 : Math.pow(-1, negativeCount);
    const totalSum = arr.reduce((acc, num) => acc + Math.abs(num), 0);
    
    return sign * totalSum;
}