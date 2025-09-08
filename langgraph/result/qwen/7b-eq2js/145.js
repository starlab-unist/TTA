function sortNumbersByDigitSum(nums) {
    function calculateWeight(number) {
        let sign = number < 0 ? -1 : 1;
        let absoluteValue = Math.abs(number);
        let digits = Array.from(String(absoluteValue), Number).map((digit, index) => index === 0 ? digit * sign : digit);
        return digits.reduce((acc, digit) => acc + digit, 0);
    }
    
    return nums.sort((a, b) => calculateWeight(a) - calculateWeight(b));
}