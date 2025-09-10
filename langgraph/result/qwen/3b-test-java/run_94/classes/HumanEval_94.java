public class HumanEval_94 {

    public static int findLargestPrimeDigitSum(int[] numbers) {
        int largestPrime = 0;
        int index = 0;
        
        while (index < numbers.length) {
            if (numbers[index] > largestPrime && isPrime(numbers[index])) {
                largestPrime = numbers[index];
            }
            index++;
        }

        int digitSum = calculateDigitSum(largestPrime);
        return digitSum;
    }

    private static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    private static int calculateDigitSum(int number) {
        String numberStr = Integer.toString(number);
        int sum = 0;
        for (char digitChar : numberStr.toCharArray()) {
            sum += Character.getNumericValue(digitChar);
        }
        return sum;
    }
}