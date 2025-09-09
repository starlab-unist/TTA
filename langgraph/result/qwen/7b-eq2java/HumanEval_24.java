public class HumanEval_24 {
    public static int findGreatestDivisor(int number) {
        int divisor = number - 1;
        while (divisor > 0) {
            if (number % divisor == 0) {
                return divisor;
            }
            divisor--;
        }
        return 1; // If no divisor found other than 1, return 1
    }
}