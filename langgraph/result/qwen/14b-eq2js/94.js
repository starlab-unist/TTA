function findLargestPrimeDigitSum(numbers) {
    function checkPrime(number) {
        for (let divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor === 0) {
                return false;
            }
        }
        return true;
    }

    let largestPrime = 0;
    let index = 0;
    while (index < numbers.length) {
        if (numbers[index] > largestPrime && checkPrime(numbers[index])) {
            largestPrime = numbers[index];
        }
        index += 1;
    }

    const digitSum = Array.from(String(largestPrime), Number).reduce((sum, digit) => sum + digit, 0);
    return digitSum;
}