public int calculateMinimumSubarraySum(int[] numbers) {
    int currentSum = 0;
    int highestNegativeSum = 0;
    for (int value : numbers) {
        currentSum += -value;
        if (currentSum < 0) {
            currentSum = 0;
        }
        highestNegativeSum = Math.max(currentSum, highestNegativeSum);
    }

    if (highestNegativeSum == 0) {
        highestNegativeSum = Arrays.stream(numbers).map(val -> -val).max().orElse(0);
    }

    int minimumSum = -highestNegativeSum;
    return minimumSum;
}