public class HumanEval_94 {
    public static int findLargestPrimeDigitSum(int[] numbers) {
        boolean isPrime(int number) {
            for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        int largestPrime = 0;
        int index = 0;
        while (index < numbers.length) {
            if (numbers[index] > largestPrime && isPrime(numbers[index])) {
                largestPrime = numbers[index];
            }
            index++;
        }

        int digitSum = 0;
        for (char digit : String.valueOf(largestPrime).toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        return digitSum;
    }
}