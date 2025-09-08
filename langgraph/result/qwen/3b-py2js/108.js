function countNums(arr) {
    function digitsSum(n) {
        let neg = 1;
        if (n < 0) n, neg = -1 * n, -1;
        n = n.toString().split('').map(Number);
        n[0] *= neg;
        return n.reduce((acc, val) => acc + val, 0);
    }

    return arr.filter(num => num > 0).map(digitsSum).length;
}