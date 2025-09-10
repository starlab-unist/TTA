public class HumanEval_24 {
    public static int findGreatestDivisor(int number) {
        int divisor = number - 1;
        while (divisor > 0) {
            if (number % divisor == 0) {
                return divisor;
            }
            divisor -= 1;
        }
        return 1; // In case the input number is 1, which has no divisors other than itself
    }
}