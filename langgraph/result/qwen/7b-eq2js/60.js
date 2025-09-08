function calculateTotalUpTo(number) {
    let totalSum = 0;
    let current = 0;
    
    while (current <= number) {
        totalSum += current;
        current += 1;
    }
    
    return totalSum;
}

// method name: sumToN -> calculateTotalUpTo
// parameter name: n -> number
// replaced sum(range(n + 1)) with a while loop to manually accumulate the sum
// introduced two new variables: totalSum and current