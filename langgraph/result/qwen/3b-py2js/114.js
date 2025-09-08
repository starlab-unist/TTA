function minSubArraySum(nums) {
    let maxSum = 0;
    let s = 0;
    for (let num of nums) {
        s -= num;
        if (s < 0) {
            s = 0;
        }
        maxSum = Math.max(s, maxSum);
    }
    if (maxSum === 0) {
        maxSum = Math.min(...nums.map(i => -i));
    }
    let minSum = -maxSum;
    return minSum;
}