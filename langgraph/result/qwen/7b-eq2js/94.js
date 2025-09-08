function findLargestPrimeDigitSum(lst) {
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
    while (index < lst.length) {
        if (lst[index] > largestPrime && checkPrime(lst[index])) {
            largestPrime = lst[index];
        }
        index++;
    }

    const digitSum = [...largestPrime.toString()].reduce((sum, char) => sum + parseInt(char), 0);
    return digitSum;
}