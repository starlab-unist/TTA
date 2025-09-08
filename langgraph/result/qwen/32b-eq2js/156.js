function convertIntegerToMinimalRoman(value) {
    const numeralValues = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000];
    const romanSymbols = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"];
    let index = numeralValues.length - 1;
    let result = "";
    while (value > 0) {
        let quotient = Math.floor(value / numeralValues[index]);
        value %= numeralValues[index];
        while (quotient > 0) {
            result += romanSymbols[index];
            quotient -= 1;
        }
        index -= 1;
    }
    return result.toLowerCase();
}