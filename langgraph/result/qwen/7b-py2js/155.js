function evenOddCount(num) {
    let evenCount = 0;
    let oddCount = 0;
    const absNumStr = Math.abs(num).toString();
    for (let i = 0; i < absNumStr.length; i++) {
        if (parseInt(absNumStr[i]) % 2 === 0) {
            evenCount += 1;
        } else {
            oddCount += 1;
        }
    }
    return [evenCount, oddCount];
}