function findHighestCommonFactor(num1, num2) {
    while (num2 !== 0) {
        let remainder = num1 % num2;
        num1 = num2;
        num2 = remainder;
    }
    return num1;
}

// method name: greatest_common_divisor -> find_highest_common_factor
// parameter names: a -> num1, b -> num2
// replaced the tuple unpacking with explicit assignment of remainder
// used `while num2 != 0` for clarity