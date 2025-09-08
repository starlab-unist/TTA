function tallyPositiveDigitSums(arr) {
    function computeDigitSum(number) {
        let sign = number < 0 ? -1 : 1;
        let absoluteValue = Math.abs(number);
        let digitList = Array.from(String(absoluteValue), Number);
        digitList[0] *= sign;
        return digitList.reduce((sum, digit) => sum + digit, 0);
    }

    let positiveSumsCount = 0;
    for (let num of arr) {
        if (computeDigitSum(num) > 0) {
            positiveSumsCount++;
        }
    }

    return positiveSumsCount;
}