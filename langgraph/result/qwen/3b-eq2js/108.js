function tallyPositiveDigitSums(numbers) {
    function computeDigitSum(number) {
        let sign = number < 0 ? -1 : 1;
        let absoluteValue = Math.abs(number);
        let digitList = [];
        
        while (absoluteValue > 0) {
            digitList.push(absoluteValue % 10);
            absoluteValue = Math.floor(absoluteValue / 10);
        }
        
        digitList[0] *= sign;
        return digitList.reduce((sum, digit) => sum + digit, 0);
    }

    let positiveSumsCount = 0;
    for (let num of numbers) {
        if (computeDigitSum(num) > 0) {
            positiveSumsCount++;
        }
    }

    return positiveSumsCount;
}