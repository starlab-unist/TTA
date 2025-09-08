function calculateMinimumSubarraySum(numbers) {
    let currentSum = 0;
    let highestNegativeSum = 0;
    for (let value of numbers) {
        currentSum += -value;
        if (currentSum < 0) {
            currentSum = 0;
        }
        highestNegativeSum = Math.max(currentSum, highestNegativeSum);
    }
    
    if (highestNegativeSum === 0) {
        highestNegativeSum = Math.max(...numbers.map(val => -val));
    }
    
    const minimumSum = -highestNegativeSum;
    return minimumSum;
}