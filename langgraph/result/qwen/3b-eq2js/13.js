function findHighestCommonFactor(num1, num2) {
    while (num2 !== 0) {
        let remainder = num1 % num2;
        num1 = num2;
        num2 = remainder;
    }
    return num1;
}