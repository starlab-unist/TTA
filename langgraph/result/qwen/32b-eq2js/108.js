function tallyPositiveDigitSums(numbers) {
    function computeDigitSum(number) {
        const sign = number < 0 ? -1 : 1;
        const absoluteValue = Math.abs(number);
        const digitList = String(absoluteValue).split('').map(Number);
        digitList[0] *= sign;
        return digitList.reduce((sum, digit) => sum + digit, 0);
    }

    let positiveSumsCount = 0;
    for (let num of numbers) {
        if (computeDigitSum(num) > 0) {
            positiveSumsCount += 1;
        }
    }

    return positiveSumsCount;
}