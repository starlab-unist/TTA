function sortNumbersByDigitSum(numbers) {
    function calculateWeight(number) {
        const sign = number < 0 ? -1 : 1;
        const absoluteValue = Math.abs(number);
        const digits = Array.from(String(absoluteValue), Number);
        digits[0] *= sign;
        return digits.reduce((sum, digit) => sum + digit, 0);
    }
    
    return numbers.sort((a, b) => calculateWeight(a) - calculateWeight(b));
}