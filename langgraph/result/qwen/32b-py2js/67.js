function fruitDistribution(s, n) {
    const lis = [];
    s.split(' ').forEach(i => {
        if (!isNaN(i)) {
            lis.push(parseInt(i, 10));
        }
    });
    return n - lis.reduce((acc, val) => acc + val, 0);
}