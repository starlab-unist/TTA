function order_by_points(nums) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) { n = -1 * n; neg = -1; }
        const nStr = n.toString();
        const nArr = nStr.split('');
        nArr[0] = parseInt(nArr[0]) * neg;
        return nArr.reduce((acc, curr) => acc + parseInt(curr), 0);
    }

    return nums.sort((a, b) => digitsSum(a) - digitsSum(b));
}