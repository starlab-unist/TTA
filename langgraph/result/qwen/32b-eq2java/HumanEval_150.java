public class HumanEval_150 {
    public static Object determineValueBasedOnDivisibility(int number, Object valueIfNotPrime, Object valueIfPrime) {
        if (number == 1) {
            return valueIfPrime;
        }

        int divisor = 2;
        while (divisor < number) {
            if (number % divisor == 0) {
                return valueIfPrime;
            }
            divisor += 1;
        }
        return valueIfNotPrime;
    }
}