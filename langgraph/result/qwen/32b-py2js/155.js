function evenOddCount(num) {
    let evenCount = 0;
    let oddCount = 0;
    for (let i of Math.abs(num).toString()) {
        if (parseInt(i) % 2 === 0) {
            evenCount += 1;
        } else {
            oddCount += 1;
        }
    }
    return [evenCount, oddCount];
}