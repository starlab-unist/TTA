public class HumanEval_94 {
    public static int findLargestPrimeDigitSum(int[] numbers) {
        int largestPrime = 0;
        int index = 0;
        while (index < numbers.length) {
            if (numbers[index] > largestPrime && checkPrime(numbers[index])) {
                largestPrime = numbers[index];
            }
            index++;
        }

        int digitSum = 0;
        String largestPrimeStr = Integer.toString(largestPrime);
        for (char c : largestPrimeStr.toCharArray()) {
            digitSum += Character.getNumericValue(c);
        }
        return digitSum;
    }

    private static boolean checkPrime(int number) {
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}