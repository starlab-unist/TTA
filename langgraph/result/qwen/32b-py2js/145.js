function orderByPoints(nums) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        const digits = Array.from(String(n), Number);
        digits[0] = digits[0] * neg;
        return digits.reduce((sum, digit) => sum + digit, 0);
    }
    return nums.sort((a, b) => digitsSum(a) - digitsSum(b));
}