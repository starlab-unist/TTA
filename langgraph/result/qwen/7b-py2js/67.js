function fruitDistribution(s, n) {
    let lis = [];
    for (let i of s.split(' ')) {
        if (!isNaN(i)) {
            lis.push(parseInt(i));
        }
    }
    return n - lis.reduce((a, b) => a + b, 0);
}