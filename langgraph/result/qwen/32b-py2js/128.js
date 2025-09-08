function prodSigns(arr) {
    if (arr.length === 0) return null;
    const hasZero = arr.includes(0);
    const negativeCount = arr.filter(x => x < 0).length;
    const prod = hasZero ? 0 : Math.pow(-1, negativeCount);
    const sumOfAbs = arr.reduce((acc, i) => acc + Math.abs(i), 0);
    return prod * sumOfAbs;
}