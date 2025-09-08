function countNums(arr) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        n = Array.from(String(n), Number);
        n[0] = n[0] * neg;
        return n.reduce((acc, val) => acc + val, 0);
    }
    return arr.map(digitsSum).filter(x => x > 0).length;
}