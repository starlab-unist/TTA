function fruitDistribution(s, n) {
    const lis = s.split(' ').filter(item => !isNaN(Number(item))).map(Number);
    return n - lis.reduce((acc, curr) => acc + curr, 0);
}