function orderByPoints(nums) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) n = -1 * n, neg = -1;
        n = Array.from(String(n), Number);
        n[0] = n[0] * neg;
        return n.reduce((a, b) => a + b, 0);
    }
    return nums.sort((a, b) => digitsSum(a) - digitsSum(b));
}