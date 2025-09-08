function prodSigns(arr) {
    if (!arr.length) return null;
    const hasZero = arr.includes(0);
    const negativeCount = arr.filter(x => x < 0).length;
    const productSign = hasZero ? 0 : Math.pow(-1, negativeCount);
    const absoluteSum = arr.reduce((acc, val) => acc + Math.abs(val), 0);
    return productSign * absoluteSum;
}